package school.faang.task_44860;

import lombok.NonNull;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(@NonNull String city) {
        Random random = new Random();
        double temperature = -20 + random.nextDouble(50);
        double humidity = random.nextDouble(100);
        long currentTime = System.currentTimeMillis();
        WeatherData weather = new WeatherData(city, temperature, humidity, currentTime);
        return weather;
    }
}
