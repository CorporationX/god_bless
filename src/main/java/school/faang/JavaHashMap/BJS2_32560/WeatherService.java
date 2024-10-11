package school.faang.JavaHashMap.BJS2_32560;

import java.util.Random;

public class WeatherService {
    private final Random random = new Random();

    private static final int MIN_TEMPERATURE = -20;
    private static final int MAX_TEMPERATURE = 40;
    private static final int MIN_HUMIDITY = 0;
    private static final int MAX_HUMIDITY = 100;

    public WeatherData getWeatherData(String cityName) {
        int temperature = random.nextInt(MIN_TEMPERATURE, MAX_TEMPERATURE + 1);
        int humidity = random.nextInt(MIN_HUMIDITY, MAX_HUMIDITY);
        return new WeatherData(cityName, temperature, humidity);
    }
}
