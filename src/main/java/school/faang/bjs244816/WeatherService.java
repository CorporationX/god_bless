package school.faang.bjs244816;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random random = new Random();
        int temperature = random.nextInt(Constants.WEATHER_MAX - Constants.WEATHER_MIN) + Constants.WEATHER_MIN;
        int humidity = random.nextInt(Constants.HUMIDITY_MAX - Constants.HUMIDITY_MIN) + Constants.HUMIDITY_MIN;

        return new WeatherData(city, temperature, humidity, System.currentTimeMillis());
    }
}
