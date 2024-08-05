package faang.school.godbless.caching;

import faang.school.godbless.caching.api.Weather;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherDataCache = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weatherData = getWeather("London");
        System.out.println(
                "Weather in " + weatherData.getCity() + " is " + weatherData.getTemperature() +
                        " degrees Celcius and humidity is " + weatherData.getHumidity()
        );

        weatherData = getWeather("London");
        System.out.println(
                "Weather in " + weatherData.getCity() + " is " + weatherData.getTemperature() +
                        " degrees Celcius and humidity is " + weatherData.getHumidity()
        );

        weatherData = getWeather("Paris");
        System.out.println(
                "Weather in " + weatherData.getCity() + " is " + weatherData.getTemperature() +
                        " degrees Celcius and humidity is " + weatherData.getHumidity()
        );

        updateWeather("Paris", new WeatherData("Paris", 20, 50));
        weatherData = getWeather("Paris");
        System.out.println(
                "Weather in " + weatherData.getCity() + " is " + weatherData.getTemperature() +
                        " degrees Celcius and humidity is " + weatherData.getHumidity()
        );

        removeWeather("London");
        weatherData = getWeather("London");
        System.out.println(
                "Weather in " + weatherData.getCity() + " is " + weatherData.getTemperature() +
                        " degrees Celcius and humidity is " + weatherData.getHumidity()
        );

        System.out.println("\n");
        printAllWeatherData();
    }

    public static WeatherData getWeather(String city) {
        if (weatherDataCache.containsKey(city)) {
            return weatherDataCache.get(city);
        }
        Weather weather = new Weather();
        WeatherData weatherData = weather.getWeatherData(city);
        weatherDataCache.put(city, weatherData);
        return weatherData;
    }

    public static void updateWeather(String city, WeatherData weatherData) {
        weatherDataCache.put(city, weatherData);
    }

    public static void removeWeather(String city) {
        weatherDataCache.remove(city);
    }

    public static void printAllWeatherData() {
        weatherDataCache.forEach((city, weatherData) -> {
            System.out.println(
                    "Weather in " + weatherData.getCity() + " is " + weatherData.getTemperature() +
                            " degrees Celcius and humidity is " + weatherData.getHumidity()
            );
        });
    }
}
