package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherCacheMap = new HashMap<>();

        WeatherData luxembourgWeather = WeatherData.getWeather(weatherCacheMap, "Luxembourg");
        WeatherData moscowWeather = WeatherData.getWeather(weatherCacheMap, "Moscow");
        WeatherData londonWeather = WeatherData.getWeather(weatherCacheMap, "London");

        System.out.println(luxembourgWeather);
        System.out.println(moscowWeather);
        System.out.println(londonWeather);

        WeatherData.updateCityWeather(weatherCacheMap, "Luxembourg");

        System.out.println("All Weathers");
        WeatherData.showAllWeatherDate(weatherCacheMap);

        System.out.println("All Weathers after deleting londonWeather");
        WeatherData.deleteCityWeather(weatherCacheMap, "London");
        WeatherData.showAllWeatherDate(weatherCacheMap);
    }
}
