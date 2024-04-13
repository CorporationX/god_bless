package faang.school.godbless.caching;

import java.util.concurrent.ThreadLocalRandom;

public class MockService {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static WeatherData doSomeLongOperation(String city) {
        return (new WeatherData(city, random.nextInt(50), random.nextDouble(50)));
    }
}
