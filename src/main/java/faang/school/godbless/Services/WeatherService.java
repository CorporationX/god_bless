package faang.school.godbless.Services;

import faang.school.godbless.models.WeatherData;

import java.util.Map;
import java.util.Random;

public class WeatherService {

    private static final int ZERO = 0;
    private static final int HUNDRED_ONE = 101;
    private static final float THIRTY = 30f;
    private static final float THIRTY_ONE = 31f;

    private static final Random RANDOM = new Random();

    public static WeatherData getWeatherForecastByCity(String city, Map<String, WeatherData> weatherForecastMap) {

        WeatherData weatherData = new WeatherData(city,
                RANDOM.nextFloat(-THIRTY, THIRTY_ONE),
                RANDOM.nextInt(ZERO, HUNDRED_ONE));

        weatherForecastMap.put(weatherData.getCity(), weatherData);
        return weatherData;
    }

    public static void printInfoFromCacheByCityAndPutInCacheIfNotExist(String city, Map<String, WeatherData> weatherForecastMap) {
        weatherForecastMap.entrySet().stream()
                .filter(e -> e.getValue().getCity().equalsIgnoreCase(city))
                .findFirst()
                .ifPresentOrElse(c -> System.out.println(c.getValue()),
                        () -> System.out.println(getWeatherForecastByCity(city, weatherForecastMap)));
    }

    public static void updateWeatherCacheByCity(String city, Map<String, WeatherData> weatherForecastMap) {
        weatherForecastMap.computeIfPresent(city, (k, v) -> {
            v.setTemperature(RANDOM.nextFloat(-THIRTY, THIRTY_ONE));
            v.setHumidity(RANDOM.nextInt(ZERO, HUNDRED_ONE));
            return v;
        });
    }

    public static void deleteWeatherCacheByCity(String city, Map<String, WeatherData> weatherForecastMap) {
        weatherForecastMap.remove(city);
    }

    public static void printAvailableCitiesInWeatherCache(Map<String, WeatherData> weatherForecastMap) {
        System.out.println(String.join(", ", weatherForecastMap.keySet()));
    }
}
