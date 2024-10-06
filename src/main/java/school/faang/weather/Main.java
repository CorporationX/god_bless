package school.faang.weather;

import java.util.HashMap;
import java.util.Map;

import static school.faang.weather.WeatherService.provideData;

public class Main {
    private static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData("Moscow", 36.6, 87);
        addWeather(weatherData);
        addWeather("Colorado");
        addWeather("Alabama");

        System.out.println(getWeatherData("Chicago"));
        System.out.println();

        printWeatherData();
        System.out.println();

        updateWeatherData("Moscow");

        removeWeatherData("Colorado");

        printWeatherData();
        System.out.println();

    }

    public static void addWeather(WeatherData weatherData) {
        WEATHER_CACHE.put(weatherData.getCity(), weatherData);
    }

    public static void addWeather(String city) {
        WEATHER_CACHE.put(city, provideData(city));
    }

    public static WeatherData getWeatherData(String city) {
        if (!WEATHER_CACHE.containsKey(city)) {
            WEATHER_CACHE.put(city, provideData(city));
        }
        return WEATHER_CACHE.get(city);
    }

    public static void updateWeatherData(String city) {
        WEATHER_CACHE.put(city, provideData(city));
    }

    public static void removeWeatherData(String city) {
        WEATHER_CACHE.remove(city);
    }

    public static void printWeatherData() {
        WEATHER_CACHE.forEach((k, v) -> {
            System.out.printf("In %s city %.2f degrees and %.2f humidity\n", k, v.getTemp(), v.getHumidity());
        });
    }


}
