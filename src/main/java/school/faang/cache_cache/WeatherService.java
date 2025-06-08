package school.faang.cache_cache;

import java.util.Date;
import java.util.Random;

public class WeatherService implements WeatherProvider {
    private Random randomizer;

    public WeatherService() {
        this.randomizer = new Random(new Date().getTime());
    }

    @Override
    public WeatherData fetchWeatherData(String city) {
        WeatherData weatherData = new WeatherData(city);
        weatherData.setTemperature(randomizer.nextDouble());
        weatherData.setHumidity(randomizer.nextDouble());
        weatherData.setTimestamp(System.currentTimeMillis());
        return weatherData;
    }
}
