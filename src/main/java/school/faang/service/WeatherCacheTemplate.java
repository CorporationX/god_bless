package school.faang.service;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class WeatherCacheTemplate {
    private long maxCacheAgeMillis;
    private Map<String, WeatherData> weatherData = new HashMap<>();


public abstract void isCacheExpired();
}
