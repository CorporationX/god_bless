package school.faang.task_56876;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random random = new Random();
    private static final double minTemperature = -20;
    private static final double maxTemperature = 20;

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = random.nextDouble(minTemperature, maxTemperature);
        double humidity = random.nextDouble(45, 100);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
