package faang.school.godbless.sprint_2.task_44862.weather_cache;

import faang.school.godbless.sprint_2.task_44862.WeatherData;

public class StandardWeatherCache extends WeatherCacheTemplate {

    private static final int STANDARD_DATA_UPDATE_PERIOD = 3_000; // 3 секунды (для тестирования)

    @Override
    public boolean isThereNoWeatherDataOrIsItOutOfDate(String city, Long maxCacheAgeMillis) {
        WeatherData cityWeatherData = getWeatherData().get(city);
        if (cityWeatherData == null) {
            return true;
        }
        return (System.currentTimeMillis() - cityWeatherData.getTimestamp()) > STANDARD_DATA_UPDATE_PERIOD;
    }
}
