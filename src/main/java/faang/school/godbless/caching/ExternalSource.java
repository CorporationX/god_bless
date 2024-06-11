package faang.school.godbless.caching;

import java.util.Random;

public class ExternalSource {
    private static Random rnd = new Random();
    public WeatherData getWeatherData(String cityName) {
        System.out.println("Request to external source");
        return new WeatherData(cityName, getRandomTemp(), getRandomHumidity());
    }

    // random temp -50.0 - +50.0
    private double getRandomTemp() {
        return (double) rnd.nextInt(-500, 500 + 1) / 10;
    }

    // random humidity 0.0 - 100.0
    private double getRandomHumidity() {
        return (double) rnd.nextInt(100 + 1) / 10;
    }
}
