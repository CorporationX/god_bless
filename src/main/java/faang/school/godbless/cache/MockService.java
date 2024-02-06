package faang.school.godbless.cache;

import java.util.Random;

public class MockService {
    private static final Random RANDOM = new Random();
    public WeatherData getWeatherFromDatabase(String name){
        return new WeatherData(name, RANDOM.nextInt(30), RANDOM.nextInt(100));
    }
}
