package faang.school.godbless.bjs218948;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weather = new HashMap<>();
    public static void main(String[] args) {
        weather.put("Moscow", new WeatherData("Moscow", 20, 2));
        weather.put("New-York", new WeatherData("New-York", 18, 12));

        System.out.println(getWeather("Berlin"));
        System.out.println(updateWeather("Moscow"));
        allWeatherInCache();
        removeWeather("Moscow");
        allWeatherInCache();

    }

    public static WeatherData getWeather(String city) {
        if (weather.containsKey(city)){
            return weather.get(city);
        }else {
            WeatherData weatherData = updateWeather(city);
            weather.put(city, weatherData);
            return weatherData;
        }
    }

    public static WeatherData updateWeather(String city) {
        WeatherData weatherData = GlobalWeatherService.getWeatherData(city);
        weather.put(city, weatherData);
        return weatherData;
    }

    public static void removeWeather(String city) {
        weather.remove(city);
    }

    public static void allWeatherInCache(){
        weather.forEach((city,weatherData)->{
            System.out.println(weatherData);
        });
    }
}
