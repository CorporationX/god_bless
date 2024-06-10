package faang.school.godbless.module1.sprint1.task10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> MY_CACHE = new HashMap<>(3);
    private static final LinkedList<String> KEYS = new LinkedList<>();
    public static void main(String[] args) {
        MY_CACHE.put("London", new WeatherData("London", 32, 15));
        MY_CACHE.put("Sidney", new WeatherData("Sidney", 22, 80));
        MY_CACHE.put("New York", new WeatherData("New York", 17, 11));
        KEYS.add("London");
        KEYS.add("Sidney");
        KEYS.add("New York");
        cityWeather("London");
        cityWeather("Moscow");
        System.out.println(MY_CACHE);

    }

    public static void cityWeather(String city) {
        if (!MY_CACHE.containsKey(city)) {
            MY_CACHE.remove(KEYS.getFirst());
            KEYS.remove(KEYS.getFirst());
            requestWeather(city);
        } else {
            KEYS.remove(city);
            KEYS.add(city);
            System.out.println(MY_CACHE.get(city));
        }

    }

    private static void requestWeather(String city) {
        KEYS.add(city);
        MY_CACHE.put(city,new WeatherData("Moscow",
                22,
                17));
        System.out.println("Requesting weather for " + MY_CACHE.get(city));
    }


}
