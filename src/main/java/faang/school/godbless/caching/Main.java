package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, WeatherData> cach = new HashMap<>();

    public static void getInfoByCity(String city) {
        if(cach.containsKey(city)) {
            WeatherData weatherData = cach.get(city);
            System.out.println(weatherData.toString());
        }
        else {
            WeatherData weatherData = anotherSource(city);
            cach.put(weatherData.getCity(), weatherData);
            getInfoByCity(city);
        }
    }

    public static WeatherData anotherSource(String city) {
        return new WeatherData(city, 40.0, 40.0);
    }

    public static void main(String[] args) {
        cach.put("city1", new WeatherData("city1", 10.0, 10.0));
        cach.put("city2", new WeatherData("city2", 20.0, 20.0));
        cach.put("city3", new WeatherData("city3", 30.0, 30.0));

        getInfoByCity("city1");
        getInfoByCity("city4");
    }
}
