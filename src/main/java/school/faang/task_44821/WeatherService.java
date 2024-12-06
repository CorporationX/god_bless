package school.faang.task_44821;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(City city) {
        double temperature = random.nextDouble(-50.0, 50.0);
        double humidity = random.nextDouble(0, 90.0);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
