package school.faang.sprint_1.task_44895;

import java.util.Random;

public class WeatherService implements WeatherProvider{
    public static final int TEMPERATURE_MIN = -10;
    public static final int TEMPERATURE_MAX = 35;
    public static final int HUMIDITY_MIN = 50;
    public static final int HUMIDITY_MAX = 90;

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        double randomTemperature = random.nextDouble(TEMPERATURE_MAX - TEMPERATURE_MIN) + TEMPERATURE_MIN;
        double randomHumidity = random.nextDouble(HUMIDITY_MAX - HUMIDITY_MIN) + HUMIDITY_MAX;
        long currentTime = System.currentTimeMillis();

        return new WeatherData(city, randomTemperature, randomHumidity, currentTime);
    }
}
