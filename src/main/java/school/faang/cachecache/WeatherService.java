package school.faang.cachecache;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, new Random().nextInt(60) - 30,
                new Random().nextInt(60) + 20, System.currentTimeMillis());
    }
}
