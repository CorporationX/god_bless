package faang.school.godbless.bjs2_18832;

import java.util.Random;

public class WeatherDataService {
    public static WeatherData randomWeather(String city) {
        int temperature = new Random().nextInt(-30, 30);
        int humidity = new Random().nextInt(0, 100);
        return new WeatherData(city, temperature, humidity);
    }
}
