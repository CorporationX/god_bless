package school.faang.task_44842;

import java.util.HashMap;

public abstract class WeatherCacheTemplate {

  protected HashMap<String, String> listCityWeather;

  abstract void getlistCityWeather();

  abstract void actualityDataInCache();

  abstract void getLastDataFromCache();

  abstract void checkDataInCache(WeatherData data);

  final void getWeatherData(String city, long maxCacheAgeMillis) {
    getLastDataFromCache();
    actualityDataInCache();
  }
}
