package faang.school.godbless.CacheCache;

import java.util.Random;

public class MockClass {
    private static Random RANDOM = new Random();
    public WeatherData getData(String city){
        return new WeatherData(city, RANDOM.nextInt(35),RANDOM.nextInt(100));
    }
}
