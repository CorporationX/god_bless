package faang.school.godbless.BJS2_18893;

import java.util.Random;

public class WeatherDataService {

    public static WeatherData getRandomWeatherData(String city) {
        Random random = new Random();
        int temperature = random.nextInt(-30, 30);
        int humidity = random.nextInt(0, 100);
        return new WeatherData(city, temperature, humidity);
    }
}
