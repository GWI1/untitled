package Les6;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        System.out.println("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=zte1OZauyN4vp73qmjjqT2JPWAfVDoxO&metric=true");

        Request.Builder builder = new Request.Builder();
        builder.addHeader("accept", "application/json");
        builder.url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=zte1OZauyN4vp73qmjjqT2JPWAfVDoxO&metric=true");
        Request requesthttp = builder
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);
    }
}
