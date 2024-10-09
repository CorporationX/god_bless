package school.faang.cashing;

import java.util.Random;

public class MockClass {
    public WeatherData getInfo(String city) {
        Random random = new Random();
        double newTemperature = random.nextDouble(-50, 50);
        double newHumidity = random.nextDouble(-80, 80);
        return new WeatherData(city, newTemperature, newHumidity);
    }
}
