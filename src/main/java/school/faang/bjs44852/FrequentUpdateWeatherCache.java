package school.faang.bjs44852;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    Map<String, WeatherDataProxy> autoUpdatedCache = new HashMap<>();
    ExecutorService executorService = Executors.newCachedThreadPool();

    public FrequentUpdateWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }

    @Override
    public WeatherData getWeatherData(String city, long maxMillis) {
        if (autoUpdatedCache.containsKey(city)) {
            return autoUpdatedCache.get(city);
        } else {
            WeatherData weather = fetchAndCacheWeatherData(city);
            WeatherDataProxy weatherProxy = new WeatherDataProxy(weather, maxMillis, getWeatherProvider());
            autoUpdatedCache.put(city, weatherProxy);
            executorService.submit(weatherProxy);
            return weatherProxy;
        }
    }

    @Override
    public boolean checkIfDataActual(String city, long maxMillis) {
        return true;
    }

    @Override
    public void updateData(long maxMillis) {
        // maybe here autoupdating
    }
}

class WeatherDataProxy extends WeatherData implements Runnable {
    private final WeatherProvider weatherProvider;
    private final long maxMillis;

    WeatherDataProxy(WeatherData weather, long maxMillis, WeatherProvider weatherProvider) {
        super(weather.getCity(), weather.getTemperature(), weather.getHumidity(), weather.getTimestamp());
        this.maxMillis = maxMillis;
        this.weatherProvider = weatherProvider;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(maxMillis);

                WeatherData weather = weatherProvider.fetchWeatherData(super.getCity());

                setTemperature(weather.getTemperature());
                setHumidity(weather.getHumidity());
                setTimestamp(weather.getTimestamp());

            } catch (InterruptedException ignored) {

            }
        }
    }
}
