package school.faang.task_44836;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = ThreadLocalRandom.current().nextDouble(-30, 30);
        double humidity = random.nextDouble() * 100;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}