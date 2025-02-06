package school.faang;

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate {
    private final WeatherService weatherService = new WeatherService();

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        System.out.printf("Weather for city %s updated\n", city);
        updateWeatherData(city);
        return weatherInCity.get(city);
    }

    @Override
    public boolean isCacheExpired(WeatherData data, long maxCacheAgeMillis) {
        return true;
    }

    @Override
    public void updateWeatherData(String city) {
        weatherInCity.put(city, weatherService.fetchWeatherData(city));
    }
}
