package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public static WeatherData getWeather(Map<String, WeatherData> cacheMap,  String cityName){
        if(cacheMap.containsKey(cityName)){
            return cacheMap.get(cityName);
        } else {
            System.out.println("Getting Weather from our resources");
            WeatherData newWeather = getWeatherInformation(cityName);
            cacheMap.put(cityName, newWeather);
            return newWeather;
        }
    }

    public static void updateCityWeather(Map<String, WeatherData> cacheMap,  String cityName){
        cacheMap.put(cityName, getWeatherInformation(cityName));
    }

    public static void deleteCityWeather(Map<String, WeatherData> cacheMap,  String cityName){
        cacheMap.remove(cityName);
    }

    public static void showAllWeatherDate(Map<String, WeatherData> cacheMap){
        for(Map.Entry<String, WeatherData> weatherData : cacheMap.entrySet()){
            System.out.println("Weather in " + weatherData.getKey() + " is " + weatherData.getValue());
        }
    }
    public static WeatherData getWeatherInformation(String cityName){
        // Возвращает диапазон от -50 до 50
        int temperature = (int)(Math.random() * 101) - 50;
        int humidity = (int)(Math.random() * 50);

        return new WeatherData(cityName, temperature, humidity);
    }
}
