package school.faang;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherService weatherService = new WeatherService();

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        if (weatherInCity.containsKey(city)
                && !isCacheExpired(weatherService.fetchWeatherData(city), maxCacheAgeMillis)) {
            System.out.printf("Weather for city %s taken from cache\n", city);
            return weatherInCity.get(city);
        }
        System.out.printf("Weather for city %s updated\n", city);
        updateWeatherData(city);
        return weatherInCity.get(city);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    @Override
    public void updateWeatherData(String city) {
        weatherInCity.put(city, weatherService.fetchWeatherData(city));
    }
}
