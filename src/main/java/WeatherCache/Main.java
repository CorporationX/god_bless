package WeatherCache;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        WeatherProvider weatherProvider = new WeatherService();

        WeatherCacheTemplate standardCache = new StandardWeatherCache(weatherProvider);
        String city = "Moscow";
        long maxCacheAgeMillis = 30000;

        try {
            WeatherData data = standardCache.getWeatherData(city, maxCacheAgeMillis);
            if (data != null) {
                System.out.println("Temperature in " + city + " (data from old cache): "
                        + data.getTemperature() + "°C");
            } else {
                System.out.println("Error retrieving weather data for city: " + city);
            }
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Error retrieving weather data for city: " + city, e);
            System.out.println("Error retrieving weather data for city: " + e.getMessage());
        }

        standardCache.clearExpiredCache(maxCacheAgeMillis);

        WeatherCacheTemplate frequentUpdateCache = new FrequentUpdateWeatherCache(weatherProvider);
        try {
            WeatherData frequentData = frequentUpdateCache.getWeatherData(city, maxCacheAgeMillis);
            if (frequentData != null) {
                System.out.println("Temperature in " + city + " (after updating cache): "
                        + frequentData.getTemperature() + "°C");
            } else {
                System.out.println("Error retrieving weather data for city: " + city);
            }
        } catch (RuntimeException e) {
            logger.log(Level.SEVERE, "Error retrieving weather data for city: " + city, e);
            System.out.println("Error retrieving weather data for city: " + e.getMessage());
        }
    }
}
