package faang.school.godbless.Weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    private static Map<String, WeatherData> weatherCache = new HashMap<>();

    public WeatherData(String city, Integer temperature, int humidity, String description) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public static String getWeatherData(String city) {
        if (weatherCache.containsKey(city)) {
            return weatherCache.get(city).toString();
        } else {
            WeatherData externalServiceWeather = WeatherService.getWeatherDataFromExternalService(city);
            if (externalServiceWeather != null) {
                weatherCache.put(city, externalServiceWeather);
                return externalServiceWeather.toString();
            } else {
                return "Нет информации о погоде для города" + city;
            }
        }
    }

    public static void updateWeatherData(Map<String, WeatherData> weatherData, WeatherData newData) {
        weatherData.put(newData.getCity(), newData);
    }

    public static void removeWeatherData(Map<String, WeatherData> weatherData, String city) {
        weatherData.remove(city);
    }

    public static void printAllCities(Map<String, WeatherData> weatherData) {
        for (String city : weatherData.keySet()){
            System.out.println(city);
        }
    }

    @Override
    public String toString() {
        return city + " temperature: " + temperature + " humidity:  " + humidity + "description";
    }

}
