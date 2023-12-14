package cache;

import java.util.Map;
import java.util.Random;

public class ExternalService {

    public static void fillWeather(String city, Map<String, WeatherData> weather) {
        Random value = new Random();
        weather.put(city, new WeatherData(city, value.nextInt(0, 30), value.nextInt(20, 100)));
    }
}