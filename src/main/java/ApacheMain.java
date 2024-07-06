
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class ApacheMain {
    String instruction = "для установки сущности через метод Post необходимо\n" +
            "1 - открыть Mock Data Generation\n" +
            "2 - установить Auth как Basic Auth прописать логин пароль\n" +
            "3 - скопировать curl --location ссылку\n";
    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        /*HttpGet httpRequest = new HttpGet("https://api.openweathermap.org/data/2.5/weather?lat=55.633687&lon=37.614060&appid=b0ee65ff3420c6a92777375357fc17e3");
        //CloseableHttpResponse httpResponse = httpClient.execute(httpRequest);
        HttpResponse httpResponse = httpClient.execute(httpRequest);
        Scanner sc = new Scanner(httpResponse.getEntity().getContent());
        System.out.println(httpResponse.getStatusLine());
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }*/
        HttpPost httpPost = new HttpPost("https://postman-echo.com/post");
        StringEntity entity = new StringEntity("{\"f\":\"3\"}");
        httpPost.setEntity(entity);
        httpPost.addHeader("Accept","application/json");
        httpPost.addHeader("Content-Type","application/json");

        //httpPost.addHeader("Accept","Authorization");
        //httpPost.addHeader("Authorization","cXdlcnR5OnF3ZXJ0eQ===");

        HttpResponse httpResponse1 = httpClient.execute(httpPost);
        Scanner sc1 = new Scanner(httpResponse1.getEntity().getContent());
        System.out.println(httpResponse1.getStatusLine());
        while(sc1.hasNextLine()){
            System.out.println(sc1.nextLine());
        }
    }
}
