package school.faang.task_44842;


import java.util.HashMap;

public class StandardWeatherCache extends WeatherCacheTemplate {

    private long maxCacheAgeMillis;
    static HashMap<String, String> listCityWeather;

    @Override
    void getlistCityWeather() {
        listCityWeather = super.listCityWeather;
    }





    @Override
    void actualityDataInCache() {

    }

    @Override
    void getLastDataFromCache() {

    }

    @Override
    void checkDataInCache(WeatherData data) {

    }
}
