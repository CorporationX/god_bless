package faang.school.godbless;

import java.util.Map;
import java.util.Random;

public class WeatherData {
    private String city;
    private Integer temperature;
    private int humidity;

    private static final String[] DESCRIPTIONS = {"Sunny", "Cloudy", "Rainy", "Stormy"};

    public WeatherData(String city, Integer temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public static String getWeatherData(Map<String, WeatherData> weatherData, String city) {
        if (weatherData.containsKey(city)) {
            return weatherData.get(city).toString();
        } else {
            WeatherData externalServiceWeather = getWeatherDataFromExternalService(city);
            if (externalServiceWeather != null) {
                return externalServiceWeather.toString();
            } else {
                return "Нет информациип о данному городу " + city;
            }
        }
    }

    public static WeatherData getWeatherDataFromExternalService(String city) {
        Random random = new Random();
        int temperature = random.nextInt(30);
        int humidity = random.nextInt(100);
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        return new WeatherData(city, temperature, humidity);
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
        return city + " temperature: " + temperature + " humidity:  " + humidity;
    }

}
