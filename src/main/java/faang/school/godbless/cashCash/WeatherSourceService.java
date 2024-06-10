package faang.school.godbless.cashCash;

import java.util.Random;

public class WeatherSourceService {

    public static WeatherData getWeatherData(String city) {
        return new WeatherData(city, new Random().nextInt(60), new Random().nextInt(100));
    }
}
