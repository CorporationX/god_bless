package school.faang.cashe.cache;

import java.util.Random;

public class MockWeatherInfo {
    private static final Random random = new Random();

    public static WeatherData getWeatherData(String city) {
        return new WeatherData(
                city,
                random.nextDouble() * 70 - 30,
                random.nextDouble() * 100
        );
    }
}
