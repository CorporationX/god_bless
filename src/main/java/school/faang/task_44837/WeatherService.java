package school.faang.task_44837;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        //температура от -10 до 50
        double temperature = -10 + random.nextDouble() * 60;

        //влажность от 1 до 100
        double humidity = random.nextDouble() * 100;

        long timestamp = System.currentTimeMillis();

        return new WeatherData(
                city,
                temperature,
                humidity,
                timestamp
        );
    }
}
