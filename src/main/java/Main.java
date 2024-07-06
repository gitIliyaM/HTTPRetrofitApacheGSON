
import data_sources.ReceiverApiDataSource;
import domain.ReceiveService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Почему-то json не видит из других классов поля и не статичные поля самого класса, который участвует в запросе и ответе
        Папка models с 2 классами, один класс принимает поле, потом его передает в тело запроса для отправки на сервер, другой класса
        должен принят объект и у себя в поле установить тело запроса. Но этого не происходит почему-то. Но если один класс отправляет и этот же класс
        принимает, то все работает. Но если сделать List с типом какого-то класса, то выдается ошибка, что сервер отправляет объект, а мы хотим принять
        List, и список ошибок, что ридер не работает, конвертер неработает и еще что-то там....
        Сделал как смог этот проект, потому что с json какие-то проблемы тут у java, нге все работает корректно...не знает какие еще установить
        зависимости, чтобы работал адаптер конвертации из объекта в список. А так без List все работает.
         */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://postman-echo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReceiverApiDataSource receiverApiDataSource = retrofit.create(ReceiverApiDataSource.class);

        ReceiveService receiveService = new ReceiveService(receiverApiDataSource);
        receiveService.fetchAll();
    }
}
