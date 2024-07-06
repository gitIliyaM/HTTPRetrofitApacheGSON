package domain;

import com.google.gson.Gson;
import data_sources.ReceiverApiDataSource;
import models.InRadiusDtoModels;
import models.ReceiverModels;
import okhttp3.ResponseBody;
import org.xml.sax.helpers.ParserAdapter;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class ReceiveService {
    static String f = "{\"f\":\"3\"}";
    final ReceiverApiDataSource receiverApiDataSource;

    public ReceiveService(ReceiverApiDataSource receiverApiDataSource){
        this.receiverApiDataSource = receiverApiDataSource;
    }
    public void fetchAll() throws IOException {
            InRadiusDtoModels dto = new InRadiusDtoModels(f);
            Call<InRadiusDtoModels> repos = receiverApiDataSource.listReceivers(dto);
            Response<InRadiusDtoModels> rep = repos.execute();
            System.out.println(rep.raw());
            System.out.println(repos.request());
            System.out.println(rep.body());
    }
}



