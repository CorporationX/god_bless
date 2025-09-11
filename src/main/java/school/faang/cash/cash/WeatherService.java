package school.faang.cash.cash;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    private static final double MIN_TEMP = -10.0;
    private static final double MAX_TEMP = 35.0;
    private static final double MIN_HUMIDITY = 10;
    private static final double MAX_HUMIDITY = 100;

    public WeatherData fetchWeatherData(String city) {
        double temperature = Math
                .round((MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble()) * 10.0) / 10.0;
        double humidity = Math
                .round(MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * random.nextDouble());

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}
