package school.faang.sprint1.task_BJS2_57007.cache;

import lombok.NonNull;
import school.faang.sprint1.task_BJS2_57007.data.WeatherData;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public WeatherData getWeatherData(@NonNull String city, long maxCacheAgeMillis) {
        if (city.isBlank() || maxCacheAgeMillis < this.getMinValueOfMaxCache()) {
            throw new IllegalArgumentException(String.format("Не валидные данные переменной %s : " + city, city));
        }

        WeatherData data = this.getCitiesWeather().get(city);

        if (data == null || this.isCacheExpired(data, maxCacheAgeMillis)) {
            data = updateWeatherData(city);
        }
        return data;
    }
}
