package Les7;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


    enum Functionality {
        GET_CURRENT_WEATHER,
        GET_WEATHER_IN_NEXT_5_DAYS
    }

    enum Periods {
        NOW,
        FIVE_DAYS
    }

    interface WeatherProvider {

        void getWeather(Periods periods) throws IOException;

    }

    public class Main {
        public static void main(String[] args) {
            UserInterface userInterface = new UserInterface();
            userInterface.runApplication();
        }
    }

    class UserInterface {

        private final Controller controller = new Controller();

        public void runApplication() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите название города на английском языке");
                String city = scanner.nextLine();

                setGlobalCity(city);

                System.out.println("Введите ответ: 1 - Получить текущую погоду, " +
                        "2 - Получить погоду на следующие 5 дней, " +
                        "выход (exit) - завершить работу");
                String result = scanner.nextLine();

                checkIsExit(result);

                try {
                    validateUserInput(result);
                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }

                try {
                    notifyController(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        private void checkIsExit(String result) {
            if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
                System.out.println("Завершаю работу");
                System.exit(0);
            }
        }

        private void setGlobalCity(String city) {

            ApplicationGlobalState.getInstance().setSelectedCity(city);
        }


        private void validateUserInput(String userInput) throws IOException {
            if (userInput == null || userInput.length() != 1) {
                throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
            }
            int answer = 0;
            try {
                answer = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                throw new IOException("Incorrect user input: character is not numeric!");
            }
        }

        private void notifyController(String input) throws IOException {
            controller.onUserInput(input);
        }

    }

    class Controller {

        WeatherProvider weatherProvider = new AccuWeatherProvider();
        Map<Integer, Functionality> variantResult = new HashMap();

        public Controller() {
            variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
            variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        }

        public void onUserInput(String input) throws IOException {
            int command = Integer.parseInt(input);
            if (!variantResult.containsKey(command)) {
                throw new IOException("There is no command for command-key " + command);
            }

            switch (variantResult.get(command)) {
                case GET_CURRENT_WEATHER:
                    getCurrentWeather();
                    break;
                case GET_WEATHER_IN_NEXT_5_DAYS:
                    getWeatherIn5Days();
                    break;
            }
        }

        public void getCurrentWeather() throws IOException {
            weatherProvider.getWeather(Periods.NOW);
        }

        public void getWeatherIn5Days() throws IOException {

            weatherProvider.getWeather(Periods.FIVE_DAYS);
        }
    }

    final class ApplicationGlobalState {

        private static ApplicationGlobalState INSTANCE;
        private final String API_KEY = "zte1OZauyN4vp73qmjjqT2JPWAfVDoxO";
        private String selectedCity = null;

        private ApplicationGlobalState() {
        }

        // Непотокобезопасный код для упрощения
        public static ApplicationGlobalState getInstance() {
            if (INSTANCE == null) {
                INSTANCE = new ApplicationGlobalState();
            }

            return INSTANCE;
        }

        public String getSelectedCity() {

            return selectedCity;
        }

        public void setSelectedCity(String selectedCity) {

            this.selectedCity = selectedCity;
        }

        public String getApiKey() {

            return this.API_KEY;
        }
    }

    class AccuWeatherProvider implements WeatherProvider {

        private static final String BASE_HOST = "dataservice.accuweather.com";
        private static final String FORECAST_ENDPOINT = "forecasts";
        private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
        private static final String API_VERSION = "v1";
        private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

        private final OkHttpClient client = new OkHttpClient();
        private final ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void getWeather(Periods periods) throws IOException {
            String cityKey = detectCityKey();
            if (periods.equals(Periods.NOW)) {
                HttpUrl url = new HttpUrl.Builder()
                        .scheme("http")
                        .host(BASE_HOST)
                        .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                        .addPathSegment(API_VERSION)
                        .addPathSegment(cityKey)
                        .addQueryParameter("apikey", API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .url(url)
                        .build();

                    Response response = client.newCall(request).execute();

                    ObjectMapper objectMapper = new ObjectMapper();
                    JsonNode country = objectMapper.readTree(String.valueOf(response)).at("geo/object/country/name");
                    JsonNode locality = objectMapper.readTree(String.valueOf(response)).at("geo/object/locality/name");
                    String fact = objectMapper.readTree(String.valueOf(response)).at("fact/temp").asText();
                    System.out.println("В городе " + locality + " температура - " + fact);




                // TODO: Сделать в рамках д/з вывод более приятным для пользователя.
                //  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
                //  Вывести пользователю только текущую температуру в C и сообщение (weather text)
            } else if (periods.equals(Periods.FIVE_DAYS)) {
                System.out.println("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=zte1OZauyN4vp73qmjjqT2JPWAfVDoxO&metric=true");

                Request.Builder builder = new Request.Builder();
                builder.addHeader("accept", "application/json");
                builder.url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=zte1OZauyN4vp73qmjjqT2JPWAfVDoxO&metric=true");
                Request requesthttp = builder
                        .build();

                String jsonResponse = client.newCall(requesthttp).execute().body().string();
                //System.out.println(jsonResponse);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode country = objectMapper.readTree(String.valueOf(jsonResponse)).at("geo/object/country/name");
                JsonNode locality = objectMapper.readTree(String.valueOf(jsonResponse)).at("geo/object/locality/name");
                String fact = objectMapper.readTree(String.valueOf(jsonResponse)).at("fact/temp").asText();
                System.out.println("В городе " + locality + " температура - " + fact);
            }





        }

        private void weatherResponse() {
        }


        public String detectCityKey() throws IOException {
            String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

            HttpUrl detectLocationURL = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment("locations")
                    .addPathSegment(API_VERSION)
                    .addPathSegment("cities")
                    .addPathSegment("autocomplete")
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("q", selectedCity)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(detectLocationURL)
                    .build();

            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) {
                throw new IOException("Невозможно прочесть информацию о городе. " +
                        "Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
            }
            String jsonResponse = response.body().string();
            System.out.println("Произвожу поиск города " + selectedCity);

            if (objectMapper.readTree(jsonResponse).size() > 0) {
                String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
                System.out.println("Найден город " + cityName + " в стране " + countryName);
            } else throw new IOException("Server returns 0 cities");

            return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
        }
    }

        /*class WeatherResponse{
            private String cityName;

            private LocalDate date;
            @JsonProperty("weather_text")
            private String weather;
            private float temperature;

            public WeatherResponse(String cityName,LocalDate date,String weather,float temperature){
                this.cityName=cityName;
                this.date=date;
                this.weather=weather;
                this.temperature=temperature;
            }
            public String getCityName(){
                return cityName;
            }
            public LocalDate getDate(){
                return date;
            }
            public String getWeather(){
                return weather;
            }
            public float getTemperature(){
                return temperature;
            }


        }

         */

