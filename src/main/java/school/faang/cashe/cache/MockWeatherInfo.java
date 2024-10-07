package school.faang.cashe.cache;

import java.util.Random;

public class MockWeatherInfo {
    private static final Random random = new Random();

    private static final int MIN_TEMPERATURE = -30;
    private static final int MAX_TEMPERATURE = 40;
    private static final int MAX_HUMIDITY = 100;

    public static WeatherData getWeatherData(String city) {
        return new WeatherData(
                city,
                random.nextDouble() * (MAX_TEMPERATURE - MIN_TEMPERATURE) + MIN_TEMPERATURE,
                random.nextDouble() * MAX_HUMIDITY
        );
    }
}
