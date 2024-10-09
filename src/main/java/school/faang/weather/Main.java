package school.faang.weather;

import java.util.HashMap;
import java.util.Map;

import static school.faang.weather.WeatherService.*;

public class Main {
    private static final Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData("Moscow", 36.6, 87);
        addWeather(weatherData, weatherCache);
        addWeather("Colorado", weatherCache);
        addWeather("Alabama", weatherCache);

        System.out.println(getWeatherData("Chicago", weatherCache));
        System.out.println();

        printWeatherData(weatherCache);
        System.out.println();

        updateWeatherData("Moscow", weatherCache);

        removeWeatherData("Colorado", weatherCache);

        printWeatherData(weatherCache);
        System.out.println();

    }
}