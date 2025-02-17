package school.faang.task_56910;

import java.sql.Timestamp;
import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Random rand = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = rand.nextDouble() * 30; // Генерация температуры от 0 до 30
        double humidity = rand.nextDouble() * 100; // Генерация влажности от 0 до 100
        long time = timestamp.getTime();
        return new WeatherData(city, temperature, humidity, time);
    }

}
