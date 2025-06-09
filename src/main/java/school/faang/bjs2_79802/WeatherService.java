package school.faang.bjs2_79802;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    public WeatherData fetchWeatherData(String city) {
        Random generator = new Random();
        return new WeatherData(city, generator.nextDouble(), generator.nextDouble(), System.currentTimeMillis());
    }
}
