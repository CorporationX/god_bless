package school.faang.cashingcashing;

import java.util.concurrent.TimeUnit;

public class Main {
    private static final long MAX_CACHE_AGE_MILLIS = 1000L;
    private static final String CITY_PRINT_FORMAT = "City: %s, ";
    private static final String TEMPERATURE_PRINT_FORMAT = "temperature: %.1f, ";
    private static final String HUMIDITY_PRINT_FORMAT = "humidity: %.1f";
    private static final String STANDARD_MAP_PRINT_FORMAT =
            "Map standard weather contain key Moscow? - ";
    private static final String FAST_CHANGING_MAP_PRINT_FORMAT =
            "Map fast changing weather contain key London? - ";

    public static void main(String[] args) {
        try {
            StandardWeatherCache standardWeathers = new StandardWeatherCache();
            FrequentUpdateWeatherCache fastChangingWeathers = new FrequentUpdateWeatherCache();

            printWeatherData(standardWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS));
            printWeatherData(standardWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS));

            printWeatherData(fastChangingWeathers.getWeatherData("London", MAX_CACHE_AGE_MILLIS));
            printWeatherData(fastChangingWeathers.getWeatherData("London", MAX_CACHE_AGE_MILLIS));

            TimeUnit.MILLISECONDS.sleep(MAX_CACHE_AGE_MILLIS);
            printWeatherData(standardWeathers.getWeatherData("Moscow", MAX_CACHE_AGE_MILLIS));

            standardWeathers.clearExpiredCache(MAX_CACHE_AGE_MILLIS);
            System.out.println(STANDARD_MAP_PRINT_FORMAT +
                    standardWeathers.getWeathersDataCache().containsKey("Moscow"));

            TimeUnit.MILLISECONDS.sleep(MAX_CACHE_AGE_MILLIS);
            standardWeathers.clearExpiredCache(MAX_CACHE_AGE_MILLIS);
            System.out.println(STANDARD_MAP_PRINT_FORMAT +
                    standardWeathers.getWeathersDataCache().containsKey("Moscow"));

            printWeatherData(fastChangingWeathers.getWeatherData("London", MAX_CACHE_AGE_MILLIS));
            fastChangingWeathers.clearExpiredCache();
            System.out.println(FAST_CHANGING_MAP_PRINT_FORMAT +
                    standardWeathers.getWeathersDataCache().containsKey("London"));
        } catch (InterruptedException error) {
            throw new RuntimeException(error);
        }
    }

    private static void printWeatherData(WeatherData weatherData) {
        System.out.printf(CITY_PRINT_FORMAT, weatherData.getCity());
        System.out.printf(TEMPERATURE_PRINT_FORMAT, weatherData.getTemperature());
        System.out.printf(HUMIDITY_PRINT_FORMAT + "\n", weatherData.getHumidity());
    }
}
