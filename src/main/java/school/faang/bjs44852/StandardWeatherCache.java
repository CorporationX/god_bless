package school.faang.bjs44852;

public class StandardWeatherCache extends WeatherCacheTemplate {
    @Override
    public boolean checkIfDataActual(String city, long maxMillis) {
        return data.get(city).getTimestamp() - System.currentTimeMillis() + maxMillis >= 0;
    }

    @Override
    public void updateData(long maxMillis) {
        data.entrySet().stream()
            .filter(pair -> !checkIfDataActual(pair.getValue().getCity(), maxMillis))
            .forEach(cityWeatherPair -> {
                WeatherData newData = fetchAndCacheWeatherData(cityWeatherPair.getKey());
                data.put(cityWeatherPair.getKey(), newData);
            });

    }

    public StandardWeatherCache(WeatherProvider weatherProvider) {
        super(weatherProvider);
    }
}
