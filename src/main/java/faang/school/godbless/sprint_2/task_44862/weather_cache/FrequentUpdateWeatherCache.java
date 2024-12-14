package faang.school.godbless.sprint_2.task_44862.weather_cache;

import faang.school.godbless.sprint_2.task_44862.WeatherData;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {

    @Override
    public boolean isThereNoWeatherDataOrIsItOutOfDate(String city, Long maxCacheAgeMillis) {
        WeatherData cityWeatherData = getWeatherData().get(city);

        if (cityWeatherData == null) {
            return true;
        }
        return (System.currentTimeMillis() - cityWeatherData.getTimestamp()) > maxCacheAgeMillis;
    }
}
