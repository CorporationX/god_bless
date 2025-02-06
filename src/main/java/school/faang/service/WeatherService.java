package school.faang.service;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private static final Random random = new Random();

    @Override
    public WeatherData fetchWeatherData(String city) {
        WeatherData result = new WeatherData(city, generateTemperature(), generateHumidity(), System.currentTimeMillis());
        return result;
    }

    private double generateTemperature() {
        // Генерируем температуру от -20 до 40 градусов
        double rawTemp = -20 + (40 - (-20)) * random.nextDouble();
        return Math.round(rawTemp * 10.0) / 10.0;
    }

    private double generateHumidity() {
        // Генерируем влажность от 60 до 100%
        double rawHumidity = 60 + (100 - 60) * random.nextDouble();
        return Math.round(rawHumidity * 10.0) / 10.0;
    }
}
