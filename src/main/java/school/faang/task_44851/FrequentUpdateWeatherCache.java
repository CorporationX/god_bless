package school.faang.task_44851;

import java.util.HashMap;
import java.util.Map;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherProvider provider;

    private final Map<String, Long> lastUpdateTimestamps = new HashMap<>();

    public FrequentUpdateWeatherCache(WeatherProvider provider) {
        this.provider = provider;
    }

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        long currentTime = System.currentTimeMillis();
        Long lastUpdate = lastUpdateTimestamps.get(city);

        if (lastUpdate == null || (currentTime - lastUpdate) >= maxCacheAgeMillis) {
            WeatherData freshData = fetchAndUpdateCache(city);
            lastUpdateTimestamps.put(city, currentTime);
            return freshData;
        }

        return cache.get(city);
    }

    @Override
    protected WeatherData fetchFreshData(String city) {
        return provider.fetchWeatherData(city);
    }
}

