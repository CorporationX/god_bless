package school.faang.cashcash;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    public static final  int MIN_TEMPERATURE = -40;
    public static final int MAX_TEMPERATURE = 40;
    public static final int MIN_HUMIDITY = 0;
    public static final int MAX_HUMIDITY = 80;

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(
                city,
                new Random().nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE),
                new Random().nextDouble(MIN_HUMIDITY, MAX_HUMIDITY),
                System.currentTimeMillis());
    }
}