package faang.school.godbless.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> weatherForecast = new HashMap<>();

    public static void main(String[] args) {


    }
    public static void getWeather(String city){
        if (weatherForecast.containsKey(city)){
            System.out.println(weatherForecast.get(city));
        }
    }

}
