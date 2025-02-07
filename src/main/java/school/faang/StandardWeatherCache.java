package school.faang;

public class StandardWeatherCache extends WeatherCacheTemplate {
    private final WeatherService weatherService = new WeatherService();

    @Override
    public WeatherData getWeatherData(String city, long maxCacheAgeMillis) {
        validateCity(city);
        validateCacheAge(maxCacheAgeMillis);
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
        validateWeatherData(data);
        return System.currentTimeMillis() - data.getTimestamp() > maxCacheAgeMillis;
    }

    @Override
    public void updateWeatherData(String city) {
        weatherInCity.put(city, weatherService.fetchWeatherData(city));
    }

    private void validateCity(String city) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City can't be null or empty");
        }
    }

    private void validateCacheAge(long maxCacheAgeMillis) {
        if (maxCacheAgeMillis < 0) {
            throw new IllegalArgumentException("Cache age can't be negative");
        }
    }

    private void validateWeatherData(WeatherData data) {
        if (data == null) {
            throw new IllegalArgumentException("WeatherData age can't be negative");
        }
    }
}
