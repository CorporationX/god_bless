package school.faang.task_44842;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public abstract class WeatherCacheTemplate {

    public static final Map<String, WeatherData> cache = new HashMap<>();


    abstract void actualityDataInCache();
    abstract void getLastDataFromCache();

    abstract void checkDataInCache(WeatherData data);


    final void getWeatherData(String city, long maxCacheAgeMillis){
        getLastDataFromCache();
        actualityDataInCache();

    }


}
