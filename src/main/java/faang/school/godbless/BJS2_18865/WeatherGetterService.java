package faang.school.godbless.BJS2_18865;

public class WeatherGetterService {
    public WeatherCacheService weatherCacheService;

    public WeatherGetterService() {
        weatherCacheService = new WeatherCacheService(); // Weather Data Cache initialization
    }

    // Random weather data generation
    public WeatherData getWeatherData(String city) {
        float randomTemp = 10.0f + (float)Math.random() * (31.0f - 10.0f);
        float randomHumidity = 10.0f + (float)Math.random() * (50.0f - 10.0f);

        return new WeatherData(city, randomTemp, randomHumidity);
    }

    // Returns Weather Data for city
    public WeatherData getFor(String city) {

        // Checking if our citi is stored in cache
        if (weatherCacheService.containsCity(city)) {
            return weatherCacheService.weatherFor(city);
        } else { // If not - store it to cache
            WeatherData newCityData = getWeatherData(city);
            weatherCacheService.storeData(city, newCityData);
            return newCityData;
        }
    }
}
