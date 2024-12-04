package school.faang.task_44824;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    private static final double MIN_TEMPERATURE = -32;
    private static final double MAX_TEMPERATURE = 50;

    private static final double MIN_HUMIDITY = -32;
    private static final double MAX_HUMIDITY = 50;

    @Override
    public WeatherData fetchWeatherData(City city) {
        long timestamp = System.currentTimeMillis();
        double temperature = ThreadLocalRandom.current().nextDouble(MIN_TEMPERATURE, MAX_TEMPERATURE);
        double humidity = ThreadLocalRandom.current().nextDouble(MIN_HUMIDITY, MAX_HUMIDITY);

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
