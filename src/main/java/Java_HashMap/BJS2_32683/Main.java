package Java_HashMap.BJS2_32683;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherMap = new HashMap<>();

    public static void main(String[] args) {
        weatherMap.put("Moscow", new WeatherData("Moscow", 10.0, 70.0));
        weatherMap.put("New York", new WeatherData("New York", 15.5, 60.0));
        weatherMap.put("Tokyo", new WeatherData("Tokyo", 20.0, 50.0));


    }


}
