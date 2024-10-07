package school.faang.JavaHashMap.BJS2_32560;

import java.util.Random;

public class WeatherService {
    private final Random random = new Random();

    public WeatherData getWeatherData(String cityName) {
        int temperature = random.nextInt(35);
        int humidity = random.nextInt(101);
        return new WeatherData(cityName, temperature, humidity);
    }
}
