package faang.school.godbless.CachingCaching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> WHEATHER_DATA = new HashMap<>();
    public static void main(String[] args) {
        Main app = new Main();
        app.update("Tallinn", new WeatherData("Tallinn", 20.0, 70.0));
        app.update("San Francisco", new WeatherData("San Francisco", 30.0, 50.0));
        app.update("Paris", new WeatherData("Paris", 18.0, 40.0));

        app.get("Tallinn");

        app.delete("Tallinn");

        app.getAll(WHEATHER_DATA);
    }

    public WeatherData get(String city){
        WeatherData data = WHEATHER_DATA.computeIfAbsent(city, key -> MockService.getCache());
        System.out.println("City: " + city + ", Temperature: " + data.getTemperature() + ", Humidity: " + data.getHumidity());
        return data;
    }
    public void update(String city, WeatherData data){
        WHEATHER_DATA.put(city, data);
    }

    public void delete (String city){
        WHEATHER_DATA.remove(city);
    }

    public void getAll (Map<String, WeatherData> weather){
        for (Map.Entry<String, WeatherData> entry : weather.entrySet()) {
        String city = entry.getKey();
        WeatherData data = entry.getValue();
        System.out.println( "City: " + city + ", Temperature: " + data.getTemperature() + ", Humidity: " + data.getHumidity());
        }
    }


}
