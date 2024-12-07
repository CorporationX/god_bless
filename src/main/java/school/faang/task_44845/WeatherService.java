package school.faang.task_44845;

import school.faang.task_44845.entity.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double weatherTemp = (15 + random.nextInt(15));
        double humidity = (30 + random.nextInt(50));
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, weatherTemp, humidity, timestamp);
    }
}
