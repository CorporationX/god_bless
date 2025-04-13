package school.faang.hash_hash;

import java.time.LocalDate;
import java.time.LocalTime;

public class WeatherService implements WeatherProvider{

    private static final long MIN_TEMPERATURE = -50;

    private static final long MAX_TEMPERATURE = 60;

    private static final long MIN_HUMIDITY = 0;

    private static final long MAX_HUMIDITY = 100;
    @Override
    public WeatherData fetchWeatherData(String city) {
        long randomTemperature = (long) (MIN_TEMPERATURE + (Math.random() *
                (MAX_TEMPERATURE - MIN_TEMPERATURE + 1)));
        long randomHumidity = (long) (MIN_HUMIDITY + (Math.random() * (MAX_HUMIDITY - MIN_HUMIDITY + 1)));
        long time = System.currentTimeMillis();
        return new WeatherData(city, randomTemperature, randomHumidity, time);
    }
}
