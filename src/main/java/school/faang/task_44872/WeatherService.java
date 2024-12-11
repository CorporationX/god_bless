package school.faang.task_44872;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -10 + random.nextDouble() * 40;
        double humidity = 0 + random.nextDouble() * 100;
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
