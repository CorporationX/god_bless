package school.faang.task_44872;

import java.util.Timer;
import java.util.TimerTask;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private long maxCacheAgeMillis;
    private Timer timer = new Timer();
    private WeatherProvider provider;

    public FrequentUpdateWeatherCache(WeatherProvider provider, long maxCacheAgeMillis) {
        this.provider = provider;
        this.maxCacheAgeMillis = maxCacheAgeMillis;
        scheduleFrequentUpdate();
    }

    private void scheduleFrequentUpdate() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (String city : cache.keySet()) {
                    WeatherData newData = provider.fetchWeatherData(city);
                    cache.put(city, newData);
                }
            }
        }, 0, maxCacheAgeMillis);
    }

    public void stopTimer() {
        timer.cancel();
    }

    @Override
    protected WeatherData getWeatherDataFromProvider(String city) {
        return provider.fetchWeatherData(city);
    }

    @Override
    protected long getMaxCacheAgeMillis() {
        return maxCacheAgeMillis;
    }
}

