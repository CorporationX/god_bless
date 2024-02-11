package HashMap4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        WeatherData city1 = new WeatherData("London", 20, 70);
        WeatherData city2 = new WeatherData("Moscow", -10, 40);
        WeatherData city3 = new WeatherData("Barcelona", 22, 30);
        Map<String, WeatherData> map = new HashMap<>();
        map.put(city1.getCity(), city1);
        map.put(city2.getCity(), city2);
        map.put(city3.getCity(), city3);
        getWeather(map, "London");
        updateWeather(map, "Moscow");
        remove(map, "Barcelona");
        getAllWeatherData(map);


    }

    public static void getWeather(Map<String, WeatherData> map, String city) {
        WeatherData weatherData = map.get(city);
        if (weatherData == null) {
            new ServiceCenter().weatherCenter();
        } else {
            System.out.println(weatherData);
        }
    }

    public static void updateWeather(Map<String, WeatherData> map, String city) {
        WeatherData weatherData = map.get(city);
        int temp = new Random().nextInt(30);//обновление температуры
        int humidity = new Random().nextInt(0, 101);//обновление показателя влажности
        weatherData.setTemperature(temp);
        weatherData.setHumidity(humidity);
        map.put(city, weatherData);
    }

    public static void remove(Map<String, WeatherData> map, String city) {
        map.remove(city);
    }

    public static void getAllWeatherData(Map<String, WeatherData> map) {
        for (Map.Entry<String, WeatherData> entry : map.entrySet()) {
            String city = entry.getKey();
            int temperature = entry.getValue().getTemperature();
            int humidity = entry.getValue().getHumidity();
            System.out.println(city + " " + temperature + " " + humidity);
        }
    }
}
