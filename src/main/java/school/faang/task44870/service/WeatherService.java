package school.faang.task44870.service;

import school.faang.task44870.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    public WeatherData fetchWeatherData(String city) {

        Random rand = new Random();
        int minTemperature = 20;
        int minHumidity = 80;
        int randIntTemp = rand.nextInt(10);
        int randIntHumidity = rand.nextInt(20);

        return new WeatherData(city, minTemperature + randIntTemp, minHumidity + randIntHumidity, System.currentTimeMillis());
    }


}
