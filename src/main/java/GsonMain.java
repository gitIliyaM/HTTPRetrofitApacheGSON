import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.text.html.parser.Parser;

public class GsonMain {
    public static void main(String[] args) {
        Gson gson = new Gson();
        InRadiusDtoGson dto = new InRadiusDtoGson("{\"f\": \"3\"}");
        String json = gson.toJson(dto);
        System.out.println(json);
        System.out.println(gson.fromJson(json, InRadiusDtoGson.class));
    }
}
class InRadiusDtoGson{
    String f;
    public InRadiusDtoGson(String  f) {
        this.f = f;
    }

    @Override
    public String toString() {
        return f;
    }
}
