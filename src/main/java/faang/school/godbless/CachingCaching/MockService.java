package faang.school.godbless.CachingCaching;

import java.util.Random;

public class MockService {
    private static final Random RANDOM = new Random();

    public WeatherData getCache() {
        String city = "City";
        double temperature = generateRandomTemperature();
        double humidity = generateRandomHumidity();
        return new WeatherData(city, temperature, humidity);
    }

    private double generateRandomTemperature() {
        return RANDOM.nextDouble() * 40.0;
    }

    private double generateRandomHumidity() {
        return RANDOM.nextDouble() * 100.0;
    }
}
