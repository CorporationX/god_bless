package faang.school.godbless.JavaHashMap.task4;

import java.util.Random;

public class MockWeather {
    private static final Random RANDOM = new Random();

    public static WeatherData getMockWeather(String city) {
        return new WeatherData(city, RANDOM.nextInt(-40, 50), RANDOM.nextInt(20,90));
    }
}
