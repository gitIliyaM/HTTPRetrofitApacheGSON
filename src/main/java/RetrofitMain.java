import com.google.gson.*;
import com.google.gson.internal.GsonBuildConfig;
import okhttp3.ResponseBody;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

interface ReceiversService {
    @POST("post")
    Call<InRadiusDto> listReceivers(@Body InRadiusDto dto);
}
public class RetrofitMain {
    public static void main(String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://postman-echo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // создаем ссылку на интерфейс
        ReceiversService service = retrofit.create(ReceiversService.class);
        //InRadiusDto dto = new InRadiusDto("{\"f\":\"3\"}");
        InRadiusDto dto = new InRadiusDto("{\"f\"",":","\"3\"}");

        Call<InRadiusDto> repos = service.listReceivers(dto);
        Response<InRadiusDto> rep = repos.execute();

        System.out.println(repos.request());
        System.out.println(rep.raw());
        System.out.println(rep.body());
    }
}
class InRadiusDto{
    String f,g,d;
    public InRadiusDto(String  f,String  g, String d) {
        this.f = f;
        this.g = g;
        this.d = d;
    }

    @Override
    public String toString() {
        return  f + g + d;
    }
}
class Receivers {
    String  ff, dd;
    String  gg;
    public Receivers(String  ff, String dd, String gg) {
        this.ff = ff;
        this.dd = dd;
        this.gg = gg;
    }
    @Override
    public String toString() {
        return ff + dd + gg;
    }
}