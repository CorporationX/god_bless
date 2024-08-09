package faang.school.godbless.caching;

import java.util.Random;

public class MockWeatherService {
    private static final int MIN_TEMP = -10;
    private static final int MAX_TEMP = 40;
    private static final int MIN_HUMIDITY = 10;
    private static final int MAX_HUMIDITY = 90;

    public WeatherData fetchWeather(String city) {
        Random random = new Random();
        double temperature = MIN_TEMP + (MAX_TEMP - (MIN_TEMP)) * random.nextDouble();
        int humidity = random.nextInt(MAX_HUMIDITY - MIN_HUMIDITY + 1) + MIN_HUMIDITY;
        return new WeatherData(city, temperature, humidity);
    }
}
