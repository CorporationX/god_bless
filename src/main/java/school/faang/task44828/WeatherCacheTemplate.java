package school.faang.task44828;

import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {
    protected static final WeatherService WEATHER_SERVICE = new WeatherService();

    protected Map<String, WeatherData> cache;

    protected abstract void isExpired(String city);

    public WeatherCacheTemplate() {
        this.cache = generateData();
    }

    private Map<String, WeatherData> generateData() {
        WeatherData weatherData =
                new WeatherData("Moscow",
                        25d,
                        50d,
                        System.currentTimeMillis());
        WeatherData weatherData2 =
                new WeatherData(
                        "Kirov",
                        30d,
                        60d,
                        System.currentTimeMillis());
        WeatherData weatherData3 =
                new WeatherData(
                        "Vyatskie Poluany",
                        15d,
                        50d,
                        System.currentTimeMillis());
        WeatherData weatherData4 =
                new WeatherData(
                        "Sosnovka",
                        10d,
                        60d,
                        System.currentTimeMillis());

        return new HashMap<>(Map.of(
                weatherData.getCity(), weatherData,
                weatherData2.getCity(), weatherData2,
                weatherData3.getCity(), weatherData3,
                weatherData4.getCity(), weatherData4
        ));
    }

    public WeatherData getWeatherData(String city) {
        return cache.get(city);
    }

    protected WeatherData updateData(WeatherData weatherData) {

        WeatherData newWeatherData = WEATHER_SERVICE.fetchWeatherData(weatherData.getCity());
        cache.computeIfPresent(weatherData.getCity(), (key, weather) -> weather = newWeatherData);

        return newWeatherData;
    }

    protected WeatherData validityPeriod(String city, long maxCacheAgeMillis) {
        WeatherData weatherData = cache.get(city);
        long currentTime = System.currentTimeMillis();

        if (!cache.containsKey(city)) {
            weatherData = WEATHER_SERVICE.fetchWeatherData(city);
            updateData(weatherData);

        } else if (currentTime - weatherData.getTimestamp() >= maxCacheAgeMillis) {
            weatherData = updateData(weatherData);
        }

        return weatherData;
    }

    public void clearExpiredCache(long maxCacheAgeMillis) {
        cache.forEach((city, value) -> validityPeriod(city, maxCacheAgeMillis));
    }

}
