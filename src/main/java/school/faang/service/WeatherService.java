package school.faang.service;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, generateTemperature(), generateHumidity(), System.currentTimeMillis());
    }

    private double generateTemperature() {
        double rawTemp = -20 + (40 - (-20)) * random.nextDouble();
        return Math.round(rawTemp * 10.0) / 10.0;
    }

    private double generateHumidity() {
        double rawHumidity = 60 + (100 - 60) * random.nextDouble();
        return Math.round(rawHumidity * 10.0) / 10.0;
    }
}
