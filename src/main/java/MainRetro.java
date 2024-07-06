import models.InRadiusDtoModels;
import models.ReceiverModels;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.List;
interface Receiver {
    @POST("post")
        //@Headers("content-Type: application/json")
    Call<ReceiverModel> Receivers(@Body ReceiverModel dto);
}
public class MainRetro {
    private static String string = "{\"f\":\"3\"}";
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://postman-echo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Receiver receiver = retrofit.create(Receiver.class);
        ReceiverModel receiverModel = new ReceiverModel(string);
        Call<ReceiverModel> call = receiver.Receivers(receiverModel);
        Response<ReceiverModel> response = call.execute();
        System.out.println(response.body());
    }
}
class ReceiverModel {
    static String f;
    public ReceiverModel(String f) {
        this.f = f;
    }
    @Override
    public String toString() {
        return f;
    }
}

