package faang.school.godbless.hashMap.caching;

import java.util.Random;

public class WeatherService {
    public static WeatherData getWeatherByCity(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-50, +50), random.nextInt(100));
    }
}
