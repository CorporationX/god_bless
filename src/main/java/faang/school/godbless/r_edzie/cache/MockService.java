package faang.school.godbless.r_edzie.cache;

import java.util.Random;

public class MockService {
    private static final Random RANDOM = new Random();

    public WeatherData getData(String city) {
        return new WeatherData(city, RANDOM.nextInt(30), RANDOM.nextInt(30));
    }
}
