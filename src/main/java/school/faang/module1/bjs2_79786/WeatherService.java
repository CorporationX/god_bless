package school.faang.module1.bjs2_79786;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {

    private static final double MIN_TEMPERATURE = -10.0;
    private static final double MAX_TEMPERATURE = 30.0;
    private static final double MIN_HUMIDITY = 10.0;
    private static final double MAX_HUMIDITY = 100.0;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = ThreadLocalRandom.current().nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
        double humidity = ThreadLocalRandom.current().nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}