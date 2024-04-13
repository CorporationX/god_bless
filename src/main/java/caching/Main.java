package caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getWeather("Иркутск"));
        System.out.println(getWeather("Лондон"));
        System.out.println(getWeather("Пхукет"));
        System.out.println(getWeather("Ереван"));
        System.out.println(getWeather("Пхукет"));

        showWeatherData();

        updateWeather("Иркутск");

        deleteWeather("Ереван");

        showWeatherData();
    }

    public static String getWeather(String city) {
        WeatherData weatherData = weatherDataCache.get(city);
        if (weatherData == null) {
            weatherData = getWeatherData(city);
            weatherDataCache.put(city, weatherData);
        }

        int temperature = weatherData.getTemperature();
        int humidity = weatherData.getHumidity();

        return city + " температура " + temperature + " градусов, влажность " + humidity + "%";
    }

    public static void updateWeather(String city) {
        WeatherData weatherData = getWeatherData(city);
        weatherDataCache.put(city, weatherData);
    }

    public static WeatherData getWeatherData(String city) {
        Random random = new Random();
        WeatherData weatherDataExternal = new WeatherData(city, random.nextInt(100) - 50, random.nextInt(100));

        return weatherDataExternal;
    }

    public static void deleteWeather(String city) {
        weatherDataCache.remove(city);
    }

    public static void showWeatherData() {
        System.out.println("В кэше хранится инфромация о погоде в следующих городах:");
        for (Map.Entry<String, WeatherData> entry : weatherDataCache.entrySet()) {
            System.out.println(entry.getKey() + " (" + entry.getValue().getTemperature() + " C, " + entry.getValue().getHumidity() + "%)");
        }
    }
}
