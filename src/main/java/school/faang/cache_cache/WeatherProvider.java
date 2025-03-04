package school.faang.cache_cache;

import java.util.Random;

public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
