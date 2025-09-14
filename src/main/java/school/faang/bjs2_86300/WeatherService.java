package school.faang.bjs2_86300;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    private static final int MIN_TEMPERATURE = 15;
    private static final int MAX_TEMPERATURE = 25;
    private static final int MIN_HUMIDITY = 30;
    private static final int MAX_HUMIDITY = 70;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = ThreadLocalRandom.current().nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
        double humidity = ThreadLocalRandom.current().nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
