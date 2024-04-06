package BJS2_4579;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> WEATHER_CITY = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(weatherInfo("Moscow", WEATHER_CITY));
        System.out.println(weatherInfo("New-York", WEATHER_CITY));
        System.out.println(weatherInfo("Los-Angeles", WEATHER_CITY));
        weatherCityUpdate("Moscow", WEATHER_CITY, new WeatherData("Moscow", 23, 12));
        weatherCityDelete("Los-Angeles", WEATHER_CITY);
        weatherInfoALL(WEATHER_CITY);
    }

    public static WeatherData weatherInfo(String city, Map<String, WeatherData> weatherData) {
        return weatherData.computeIfAbsent(city, k -> weatherGetData(city));
    }

    private static WeatherData weatherGetData(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-20, 31), random.nextInt(30, 96));
    }

    private static void weatherCityUpdate(String city, Map<String, WeatherData> weatherData, WeatherData data) {
        weatherData.put(city, data);
    }

    private static void weatherCityDelete(String city, Map<String, WeatherData> weatherData) {
        weatherData.remove(city);
    }

    private static void weatherInfoALL(Map<String, WeatherData> weatherData) {
        for (Map.Entry<String, WeatherData> data : weatherData.entrySet()) {
            if (data.getKey() != null) {
                System.out.println(data.getKey() + " Температура: " + data.getValue().getTemperature() + "°,"
                        + "Влажность: " + data.getValue().getHumidity() + "%");
            }
        }
    }
}
