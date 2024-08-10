package weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<String, WeatherData> weatherStore = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(getWeatherInCity("Moscow"));
        System.out.println(getWeatherInCity("Moscow"));
        System.out.println(getWeatherInCity("Omsk"));
        System.out.println(getWeatherInCity("Vladimir"));

        updateWeatherInCity(new WeatherData("Moscow", 10, 55));
        printWeatherInCities();
        removeWeatherInCity("Omsk");
        printWeatherInCities();
    }

    public static WeatherData getWeatherInCity(String city) {
        if (!weatherStore.containsKey(city)) {
            WeatherData weatherData = makeWeatherInCity(city);
            weatherStore.put(city, weatherData);

            return weatherData;
        }

        return weatherStore.get(city);
    }

    public static void updateWeatherInCity(WeatherData weatherData) {
        weatherStore.put(weatherData.getCity(), weatherData);
    }

     public static void removeWeatherInCity(String city) {
        weatherStore.remove(city);
    }

    public static void printWeatherInCities() {
        weatherStore.forEach((city, weatherData) -> System.out.println(weatherData));
    }

    private static WeatherData makeWeatherInCity(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(30), random.nextInt(100));
    }
}
