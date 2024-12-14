package school.faang.task_44820;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -25 + (65 * random.nextDouble());
        double humidity = random.nextDouble() * 100;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
