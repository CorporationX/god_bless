package faang.school.godbless;

import java.util.Map;

public class WeatherData {
    private String city;
    private Integer temperature;
    private int humidity;

    public WeatherData(String city, Integer temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public static String getWeatherData(Map<String, WeatherData> weatherData, String city) {
        if (weatherData.containsKey(city)) {
            return weatherData.get(city).toString();
        } else {
            WeatherData weatherData1 = getWeatherDataFromExternalService(city);
            if (weatherData1 != null) {
                return weatherData1.toString();
            } else {
                return "Нет информациип о данному городу " + city;
            }
        }
    }

    public static WeatherData getWeatherDataFromExternalService(String city) {
        return null;
    }

    public static void updateWeatherData(Map<String, WeatherData> weatherData, String city, WeatherData newData) {
        weatherData.put(city, newData);
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
        return city + " temperature: " + temperature + " humidity:  " + humidity;
    }



}
