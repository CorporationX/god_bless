package school.faang.bjs2_86074;

import lombok.experimental.SuperBuilder;

import java.util.Map;

//@SuperBuilder Такая аннотация не помогла. Без конструктора ошибку выдавал, что конструктор нужен
public class StandardWeatherCache extends WeatherCacheTemplate {

    public StandardWeatherCache(Map<String, WeatherData> standardData) {
        super(standardData);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        return (currentTime - data.getTimeStamp()) > maxCacheAgeMillis;
    }
}
