package school.faang.task_56876;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = random.nextDouble(-20, 20);
        double humidity = random.nextDouble(45, 100);
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
