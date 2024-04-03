package HashMap4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static Map<String, WeatherData> weatherCache = new HashMap<>();
    public static ServiceCenter serviceCenter = new ServiceCenter();
    private static final String LONDON = "London";
    private static final String MOSCOW = "Moscow";
    private static final String BARCELONA = "Barcelona";

    public static void main(String[] args) {
        WeatherData city1 = initCache(LONDON, 20, 70);
        WeatherData city2 = initCache(MOSCOW, -10, 40);
        WeatherData city3 = initCache(BARCELONA, 22, 30);
        System.out.println(weatherCache);
        WeatherData cityWeather = getCityWeather(LONDON);
        System.out.println(cityWeather);
        updateWeather(MOSCOW);
        remove(BARCELONA);
        getAllWeatherData();


    }
    public static WeatherData initCache(String city, int temperature, int humidity){

        if(weatherCache.containsKey(city)){
            return weatherCache.get(city);
        }else{
            WeatherData weatherData = new WeatherData(city, temperature, humidity);
            weatherCache.put(city,weatherData);
            return weatherData;
        }
    }

    public static WeatherData getCityWeather(String city) {
        WeatherData weatherData = weatherCache.get(city);
        if (weatherData == null) {
            WeatherData weatherCity = serviceCenter.weatherCenter(city);
            weatherCache.put(city,weatherCity);
            return weatherCity;
        } else {
            return weatherData;
        }
    }

    public static void updateWeather(String city) {
        WeatherData weatherData = serviceCenter.weatherCenter(city);
        weatherCache.put(city, weatherData);
    }

    public static void remove(String city) {
        weatherCache.remove(city);
    }

    public static void getAllWeatherData() {
        for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
            String city = entry.getKey();
            int temperature = entry.getValue().getTemperature();
            int humidity = entry.getValue().getHumidity();
            System.out.println(city + " " + temperature + " " + humidity);
        }
    }
}
