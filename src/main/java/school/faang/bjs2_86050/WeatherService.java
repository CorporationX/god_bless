package school.faang.bjs2_86050;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random random = new Random();

    private static final int MIN_TEMP = 10;
    private static final int MAX_TEMP = 40;
    private static final int MIN_HUMIDITY = 20;
    private static final int MAX_HUMIDITY = 80;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temp = MIN_TEMP + (MAX_TEMP) * random.nextDouble();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY) * random.nextDouble();
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temp, humidity, timestamp);
    }
}
