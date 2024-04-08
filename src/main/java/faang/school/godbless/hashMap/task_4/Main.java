package faang.school.godbless.hashMap.task_4;

import faang.school.godbless.hashMap.task_4.model.MockSource;
import faang.school.godbless.hashMap.task_4.model.WeatherData;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();
    private static final MockSource MOCK_SOURCE = new MockSource();

    public static void main(String[] args) {
        add("Moskva", new WeatherData("Moskva", 8, 44));
        add("Krasnodar", new WeatherData("Krasnodar", 17, 57));
        System.out.println("Кэш до запроса на доп.источник: ");
        printAll();
        System.out.println("Берем информацию об одном городе из доп.источника: ");
        System.out.println(getWeatherData("Ekaterinburg"));
        System.out.println();
        System.out.println("Кэш после запроса к доп.источнику: ");
        printAll();
        System.out.println("Берем информацию об одном городе из кэша: ");
        System.out.println(getWeatherData("Krasnodar"));
        System.out.println();
        System.out.println("Кэш после удаления одного из городов: ");
        remove("Moskva");
        printAll();
        System.out.println("Кэш после обновления информации о городах: ");
        updateCache();
        printAll();
    }

    private static void add(String city, WeatherData weather) {
        WEATHER_CACHE.put(city, weather);
    }

    private static WeatherData getWeatherData(String city) {
        WeatherData weatherData = WEATHER_CACHE.get(city);
        if (weatherData == null) {
            weatherData = MOCK_SOURCE.getWeatherInfo(city);
            WEATHER_CACHE.put(city, weatherData);
        }
        return weatherData;
    }

    private static void updateCache() {
        WEATHER_CACHE.keySet().forEach(city -> {
            WeatherData weather = MOCK_SOURCE.getWeatherInfo(city);
            WEATHER_CACHE.put(city, weather);
        });
    }

    private static void remove(String city) {
        WEATHER_CACHE.remove(city);
    }

    private static void printAll() {
        WEATHER_CACHE.forEach((key, value) -> System.out.println(key + " : " + value));
        System.out.println();
    }
}