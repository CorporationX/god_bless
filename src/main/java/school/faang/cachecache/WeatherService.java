package school.faang.cachecache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        checkNameCity(city);
        long timestamp = System.currentTimeMillis();

        Random random = new Random();
        double temperatureRandom = -40 + (random.nextDouble() * 80);
        double temperature = Math.round(temperatureRandom * 10.0) / 10.0;
        double humidityRandom = 30 + (random.nextDouble() * 30);
        double humidity = Math.round(humidityRandom * 10.0) / 10.0;
        return new WeatherData(city, temperature, humidity, timestamp);
    }

    public void checkNameCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Название города не может быть пустым");
        }
    }
}