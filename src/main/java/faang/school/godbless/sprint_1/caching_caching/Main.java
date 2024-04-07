package faang.school.godbless.sprint_1.caching_caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final WeatherService WEATHER_SERVICE = new WeatherService();
    private static Map<String, WeatherData> map = new HashMap<>();

    static {
        map.put("London", new WeatherData("London", 20, 40));
        map.put("Moscow", new WeatherData("Moscow", 24, 50));
        map.put("Sochi", new WeatherData("Sochi", 29, 60));
    }

    public static void main(String[] args) {

        // get weather
        System.out.println(getWeatherByCity("London"));
        System.out.println(getWeatherByCity("Moscow"));

        // get weather from mock and save in cache
        System.out.println(getWeatherByCity("Korolev"));

        System.out.println();

        // print all cities available in cache
        System.out.println(findAllCitiesInCache());

        System.out.println();

        // delete city from cache
        deleteByCity("London");
        System.out.println(findAllCitiesInCache());

        System.out.println();

        // update weather in Moscow
        updateWeather(new WeatherData("Moscow", 1, 99));
        System.out.println(getWeatherByCity("Moscow"));
    }

    public static WeatherData getWeatherByCity(String city) {
        if (!map.containsKey(city)) {
            WeatherData receivedWeatherData = WEATHER_SERVICE.getWeatherData(city);
            map.put(city, receivedWeatherData);
        }

        return map.get(city);
    }

    public static void updateWeather(WeatherData weatherData) {
        map.put(weatherData.getCity(), weatherData);
    }

    public static void deleteByCity(String city) {
        map.remove(city);
    }

    public static Set<String> findAllCitiesInCache() {
        return map.keySet();
    }

}
