package faang.school.godbless.cache;

import java.util.Random;

public class ExternalService {
    public WeatherData getWeatherData(String city) {
        return new WeatherData(city, new Random().nextInt(50), new Random().nextInt(100));
    }
}
