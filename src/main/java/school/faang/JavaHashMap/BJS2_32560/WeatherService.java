package school.faang.JavaHashMap.BJS2_32560;

import java.util.Random;

public class WeatherService {
    private final Random random = new Random();

    public WeatherData getWeatherData(String cityName) {
        int temperature = random.nextInt(35); // Генерирует число от 0 до 34
        int humidity = random.nextInt(101);   // Генерирует число от 0 до 100
        return new WeatherData(cityName, temperature, humidity);
    }
}
