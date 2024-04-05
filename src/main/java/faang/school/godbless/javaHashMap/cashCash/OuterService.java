package faang.school.godbless.javaHashMap.cashCash;

import java.util.Random;

public class OuterService {
    public WeatherData getWeatherData(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-60, 60), random.nextInt(0, 90));
    }
}
