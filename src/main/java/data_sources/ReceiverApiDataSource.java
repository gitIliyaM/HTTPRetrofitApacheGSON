package data_sources;

import models.InRadiusDtoModels;
import models.ReceiverModels;
import retrofit2.Call;
import retrofit2.Response;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import java.util.ArrayList;
import java.util.List;
public interface ReceiverApiDataSource {
    @POST("post")
    //@Headers("content-Type: application/json")
    Call<InRadiusDtoModels> listReceivers(@Body InRadiusDtoModels dto);
}
