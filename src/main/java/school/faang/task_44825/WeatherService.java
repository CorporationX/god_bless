package school.faang.task_44825;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city == null) {
            throw new IllegalArgumentException("City doesn't exist");
        }
        double temperature = random.nextDouble(((50 + 50 + 1) - 50)) * (random.nextBoolean() ? 1 : -1);
        double humidity = random.nextDouble(100 + 1);
        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}