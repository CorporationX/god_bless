package school.faang.bjs44852;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public boolean checkIfDataActual(String city, long maxMillis) {
        return true;
    }

    @Override
    public void updateData(long maxMillis) {
        for (String city : data.keySet()) {
            scheduleAutoUpdate(city, maxMillis);
        }
    }

    private void scheduleAutoUpdate(String city, long maxMillis) {
        scheduler.scheduleAtFixedRate(() -> {
            WeatherData weather = fetchAndCacheWeatherData(city);
            data.put(city, weather);
        }, maxMillis, maxMillis, TimeUnit.MILLISECONDS);
    }
}
