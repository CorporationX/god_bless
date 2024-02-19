package faang.school.godbless.r_edzie.hashmaps.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CACHED_WEATHER = new HashMap<>();
    private static final MockService MOCK_SERVICE = new MockService();

    public static void main(String[] args) {
        System.out.println(getWeather("Москва").toString());

        System.out.println(getWeather("Москва").toString());

        update("Москва");

        System.out.println(getWeather("Сочи"));;
        getWeather("Краснодар");
        remove("Краснодар");

        System.out.println("---");

        printAll();
    }

    public static WeatherData getWeather(String city) {
        WeatherData cachedData = CACHED_WEATHER.get(city);

        if (cachedData == null) {
            cachedData = MOCK_SERVICE.getData(city);
            CACHED_WEATHER.put(city, cachedData);
        }

        return cachedData;
    }

    public static void update(String city) {
        CACHED_WEATHER.put(city, MOCK_SERVICE.getData(city));
    }

    public static void remove(String city) {
        CACHED_WEATHER.remove(city);
    }

    public static void printAll() {
        CACHED_WEATHER.forEach((city, weatherData) -> System.out.println(weatherData.toString()));
    }
}
