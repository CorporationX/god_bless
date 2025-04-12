package school.faang.weather.service;

import school.faang.weather.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) { // получение данных о погоде
        Random random = new Random();
        double temperature = -10 + random.nextDouble() * 40;
        double humidity = 20 + random.nextDouble() * 60;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}

