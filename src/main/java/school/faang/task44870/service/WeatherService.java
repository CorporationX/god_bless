package school.faang.task44870.service;

import school.faang.task44870.model.WeatherData;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private final Random rand = new Random();
    private final static int MIN_TEMPERATURE = 20;
    private final static int MIN_HUMIDITY = 80;

    public WeatherData fetchWeatherData(String city) {

        int randIntTemp = rand.nextInt(10);
        int randIntHumidity = rand.nextInt(20);

        return new WeatherData(
                city,
                MIN_TEMPERATURE + randIntTemp,
                MIN_HUMIDITY + randIntHumidity,
                System.currentTimeMillis());
    }


}
