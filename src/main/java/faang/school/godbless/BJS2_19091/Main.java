package faang.school.godbless.BJS2_19091;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, WeatherData> weatherConditions = new HashMap<>();

    public static WeatherData getWeather(String city){
        if (weatherConditions.containsKey(city)){
            weatherConditions.get(city);
        } else {
            WeatherData weather = Weather.getWeatherFromInt(city);
            weatherConditions.put(city, weather);
        }
        return weatherConditions.get(city);
    }

    public static void updateWeatherData(String city, int temperature, int humidity){
        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        weatherConditions.replace(city, weatherConditions.get(city), weatherData);
    }

    public static void removeWeatherData(String city){
        weatherConditions.remove(city);
    }

    public static void showAllCityWeather(Map<String, WeatherData> weather){
        weather.forEach((key, value) -> System.out.println(key + " - " + value.getTemperature() + ", " + value.getHumidity()));
    }

    public static void main(String[] args) {

        weatherConditions.put("Novosibirsk", new WeatherData("Novosibirsk", 23,73));
        weatherConditions.put("Moscow", new WeatherData("Moscow", 18,33));
        getWeather("Novosibirsk");
        updateWeatherData("Novosibirsk", 18, 67);
        removeWeatherData("Moscow");
        showAllCityWeather(weatherConditions);
    }
}
