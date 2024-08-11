package faang.school.godbless.bjs218948;

import java.util.Random;

public class GlobalWeatherService {
    public static WeatherData getWeatherData(String city) {
        return  new WeatherData(city, new Random().nextInt(50), new Random().nextInt(20));
    }
}
