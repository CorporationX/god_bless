package school.faang.bjs244816;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    @Override
    boolean checkTtl(long lastCallTime) {
        return false;
    }

    @Override
    void clearExpiredCache() {
        long currentTime = System.currentTimeMillis();
        getWeatherDataLog().entrySet()
                .removeIf(entry -> currentTime - entry.getValue().getTimestamp() > Constants.FREQUENT_UPDATE_TTL);
    }
}
