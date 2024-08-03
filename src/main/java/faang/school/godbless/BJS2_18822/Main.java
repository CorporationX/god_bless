package faang.school.godbless.BJS2_18822;

import java.util.HashMap;

public class Main {
    public static HashMap<String, WeatherData> cache = new HashMap<>();
    public static void main(String[] args) {

    }

    public static WeatherData infoWeather(String city) {
        if(cache.containsKey(city)) {
            return cache.get(city);
        } else {
            cache.put(city, DB.getFromDB(city));
            return cache.get(city);
        }
    }
}
