package school.faang.task44828;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public abstract class WeatherCacheTemplate {
    protected static final WeatherService WEATHER_SERVICE = new WeatherService();

    protected Map<String, WeatherData> cache;

    protected abstract WeatherData getWeatherData(String city, long maxCacheAgeMillis);

    public abstract WeatherData getWeatherData(String city);

    protected WeatherData updateData(WeatherData weatherData, long maxCacheAgeMillis){

        WeatherData newWeatherData = WEATHER_SERVICE.fetchWeatherData(weatherData.getCity());

        cache.computeIfPresent(weatherData.getCity(), (key, weather) -> weather = newWeatherData);

        return newWeatherData;
    }

    protected WeatherData validityPeriod(String city, long maxCacheAgeMillis){
        WeatherData weatherData = cache.get(city);
        long currentTime = System.currentTimeMillis();

        if (!cache.containsKey(city)) {
            weatherData = WEATHER_SERVICE.fetchWeatherData(city);
            updateData(weatherData, maxCacheAgeMillis);

        }else if (currentTime - weatherData.getTimestamp() >= maxCacheAgeMillis){
            weatherData = updateData(weatherData, maxCacheAgeMillis);
        }

        return weatherData;
    }

}
