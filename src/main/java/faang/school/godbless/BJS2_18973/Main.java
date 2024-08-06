package faang.school.godbless.BJS2_18973;

import java.util.HashMap;
import java.util.Objects;


public class Main {
    private static HashMap<String, WeatherData> weatherCache = new HashMap<>();
    private static ExternalWeatherService externalWeatherService = new ExternalWeatherService();

    private static WeatherData getWeatherInfo(String city) {
        WeatherData weatherData = weatherCache.get(city);
        if (Objects.nonNull(weatherData)) {
            return weatherData;
        } else {
            updateWeatherCache(city);
            return weatherCache.get(city);
        }
    }

    private static void updateWeatherCache(String city) {
        weatherCache.put(city, externalWeatherService.requestWeatherData(city));
    }

    private static void removeWeatherDataFromCache(String city) {
        weatherCache.remove(city);
    }

    private static void viewCityInWeatherCache() {
        weatherCache.keySet().forEach(System.out::println);
    }

    public static void main(String[] args) {
        updateWeatherCache("Moscow");
        updateWeatherCache("SPb");
        updateWeatherCache("Murmansk");
        System.out.println();

        viewCityInWeatherCache();
        System.out.println();

        System.out.println(getWeatherInfo("Moscow"));
        System.out.println(getWeatherInfo("NewYork"));
        System.out.println();

        removeWeatherDataFromCache("Moscow");
        viewCityInWeatherCache();
    }
}
