package cache;

import java.util.Map;
import java.util.Random;

public class ExternalService {

    public static WeatherData fillWeather(String city) {
        Random value = new Random();
        return new WeatherData(city, value.nextInt(0, 30), value.nextInt(20, 100));
    }
}