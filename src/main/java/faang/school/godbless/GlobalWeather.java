package faang.school.godbless;

import java.util.Random;

public class GlobalWeather {
    public static WeatherData getWeather(String city) {
        Random random = new Random();
        int temperature = random.nextInt(-20, 50);
        int hummidity = random.nextInt(0, 100);
        return new WeatherData(city, temperature, hummidity);
    }
}
