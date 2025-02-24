package school.faang.bjs244816;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    boolean checkTtl(long lastCallTime) {
        return System.currentTimeMillis() > lastCallTime + Constants.STANDARD_TTL;
    }

    @Override
    void clearExpiredCache() {
        getWeatherDataLog().entrySet()
                .removeIf(entry -> checkTtl(entry.getValue().getTimestamp()));
    }
}
