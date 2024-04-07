package faang.school.godbless.hashMap.task_4.model;

import java.util.Random;

public class MockSource {
    private static final Random RANDOM = new Random();

    public WeatherData getWeatherInfo(String city) {
        return new WeatherData(city, RANDOM.nextInt(-25, 35), RANDOM.nextInt(30, 80));
    }
}