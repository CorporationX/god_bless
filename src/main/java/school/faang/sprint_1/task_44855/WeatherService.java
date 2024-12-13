package school.faang.sprint_1.task_44855;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    public WeatherData fetchWeatherData(String city) {
        double temperature = -30 + (50 * random.nextDouble());
        double humidity = 10 + (90 * random.nextDouble());
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
