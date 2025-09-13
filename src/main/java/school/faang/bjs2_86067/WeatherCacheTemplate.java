package school.faang.bjs2_86067;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();

    private final WeatherProvider weatherProvider = new WeatherService();

    static {
        final WeatherData londonWeatherData = new WeatherData(City.LONDON.getCityName(), 20, 30,
                System.currentTimeMillis() + 1000);
        final WeatherData parisWeatherData = new WeatherData(City.PARIS.getCityName(), 15, 25,
                System.currentTimeMillis());
        final WeatherData brazilWeatherData = new WeatherData(City.BRAZIL.getCityName(), 25, 33,
                System.currentTimeMillis() + 20000);
        final WeatherData sochiWeatherData = new WeatherData(City.SOCHI.getCityName(), 30, 50,
                System.currentTimeMillis() - 500);
        final WeatherData madridWeatherData = new WeatherData(City.MADRID.getCityName(), 30, 50,
                System.currentTimeMillis());

        weatherCache.put(City.LONDON.getCityName(), londonWeatherData);
        weatherCache.put(City.PARIS.getCityName(), parisWeatherData);
        weatherCache.put(City.BRAZIL.getCityName(), brazilWeatherData);
        weatherCache.put(City.SOCHI.getCityName(), sochiWeatherData);
        weatherCache.put(City.MADRID.getCityName(), madridWeatherData);
    }

    protected abstract boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis);

    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = weatherCache.get(city);
        if (weatherData == null || isCacheExpired(weatherData, maxCacheAgeMillis)) {
            weatherData = weatherProvider.fetchWeatherData(city);
        }
        weatherCache.put(city, weatherData);
        return weatherData;
    }

    public void forceUpdateWeather(String city) {
        weatherCache.put(city, weatherProvider.fetchWeatherData(city));
    }
}