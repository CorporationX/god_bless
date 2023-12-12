package faang.school.godbless.Caching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public static void main(String[] args) {

        weatherDataMap.put("London", new WeatherData("London", 10, 98));
        weatherDataMap.put("Peking", new WeatherData("Peking", 3, 26));
        weatherDataMap.put("Seattle", new WeatherData("Seattle", -1, 91));
        weatherDataMap.put("Ulan-Ude", new WeatherData("Ulan-Ude", -6, 72));

        weatherInfo("London");  //показать информацию о существующем Лондоне
        weatherInfo("Moskow");  //показать информацию об отсутствующей Москве
        removeWeather("Ulan-Ude");
        updateWeather("Peking");
        printWeather();
    }

    public static void weatherInfo(String city) {
        if (weatherDataMap.containsKey(city))
            System.out.println(weatherDataMap.get(city));
        else {
            weatherDataMap.put(city, ServerData.getWeather(city));
            System.out.println(weatherDataMap.get(city));
        }
    }

    public static void updateWeather(String city) {
        weatherDataMap.put(city, ServerData.getWeather(city));
    }

    public static void removeWeather(String city) {
        weatherDataMap.remove(city);
    }

    public static void printWeather() {
        System.out.println("Погода на сегодня: ");
        for (Map.Entry<String, WeatherData> weather : weatherDataMap.entrySet())
            System.out.println(weather.getValue());
    }

}
