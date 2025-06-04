package school.faang.bjs2_79779;


import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    private static final double MIN_TEMPERATURE = -30;
    private static final double MAX_TEMPERATURE = 35;
    private static final double MIN_HUMIDITY = 10;
    private static final double MAX_HUMIDITY = 100;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = ThreadLocalRandom.current().nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
        double humidity = ThreadLocalRandom.current().nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
