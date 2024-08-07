package faang.school.godbless.javahashmap.cache;

import java.util.HashMap;

public class Meteorologist {

    private final HashMap<String, WeatherData> weatherDataCache = new HashMap<>();

    public WeatherData getWeatherData(String cityName) {
        if (weatherDataCache.containsKey(cityName)) {
            return weatherDataCache.get(cityName);
        }

        WeatherData weatherData = getExternalWeatherData(cityName);
        weatherDataCache.put(cityName, weatherData);
        return weatherData;
    }

    public void updateWeatherData(WeatherData updatedWeatherData) {
        weatherDataCache.put(updatedWeatherData.getCity(), updatedWeatherData);
    }

    public void deleteWeatherData(String cityName) {
        weatherDataCache.remove(cityName);
    }

    public void printCachedCities() {
        for (WeatherData weatherData : weatherDataCache.values()) {
            if (weatherData != null) {
                System.out.println(weatherData);
            }
        }
    }

    public HashMap<String, WeatherData> getDeepCopyOfWeatherDataCache() {
        HashMap<String, WeatherData> weatherDataCacheToReturn = new HashMap<>();
        weatherDataCache.forEach((city, data) -> weatherDataCacheToReturn.put(city,
                new WeatherData(data.getCity(), data.getTemperature(), data.getHumidity())));
        return weatherDataCacheToReturn;
    }

    private WeatherData getExternalWeatherData(String cityName) {
        return new WeatherData(cityName, 15.5, 74.8);
    }

}
