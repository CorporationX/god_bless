package faang.school.godbless.Task_9;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, WeatherData> map = new HashMap<>();
        map.put("Moscow", new WeatherData("Moscow", -20, 50));
        map.put("London", new WeatherData("London", 20, 30));
        map.put("New-York", new WeatherData("New-York", 10, 60));

        weatherInfo(map, "Paris");


    }

    static void weatherInfo(Map<String, WeatherData> map, String cityName) {
        if (cityName != null) {
            if (map.containsKey(cityName)) {
                Integer humidity = map.get(cityName).getHumidity();
                Integer temperature = map.get(cityName).getTemperature();
                System.out.println("Humidity = " + humidity + " and " + "temperature = " + temperature);
            } else {
                map.put(cityName, new WeatherInfo().wInfo(cityName));
                System.out.println(map);
            }
        }
    }
}
