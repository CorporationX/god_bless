package bjs2_29014;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Map<String, WeatherData> weatherAcrossCities;

    public static void main(String[] args) {
        weatherAcrossCities = new HashMap<>() {{
            put("Moscow", new WeatherData("Moscow", 12.5, 40));
            put("California", new WeatherData("California", 30.0, 30));
            put("Amsterdam", new WeatherData("Amsterdam", 20.0, 50));
        }};

        searchCityWeatherData("Moscow");
        searchCityWeatherData("New-York");
        System.out.println();
        updateCityWeatherData("California", 0.0, 20);
        updateCityWeatherData("New-York", 30);
        updateCityWeatherData("New-York", 20.0);
        printAllCities();
        System.out.println();
        removeCity("California");
        System.out.println();
        printAllCities();
    }

    public static void searchCityWeatherData(String city) {
        if (!weatherAcrossCities.containsKey(city)) {
            searchUnknownCityWeatherData(city);
        }
        System.out.println(weatherAcrossCities.get(city));
    }

    public static void searchUnknownCityWeatherData(String city) {
        Random random = new Random();
        double temperature = Math.round(random.nextDouble(-30.0, 45.0));
        int humidity = random.nextInt(0, 100);
        weatherAcrossCities.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void updateCityWeatherData(String city, double temperature, int humidity) {
        WeatherData weatherData = weatherAcrossCities.
                computeIfAbsent(city, k -> new WeatherData(city, temperature, humidity));
        weatherData.setTemperature(temperature);
        weatherData.setHumidity(humidity);
    }

    public static void updateCityWeatherData(String city, double temperature) {
        int humidity = new Random().nextInt(0, 100);
        weatherAcrossCities.computeIfAbsent(city, k -> new WeatherData(city, temperature, humidity));
    }

    public static void updateCityWeatherData(String city, int humidity) {
        double temperature = new Random().nextDouble(-30.0, 45.0);
        weatherAcrossCities.computeIfAbsent(city, k -> new WeatherData(city, temperature, humidity));
    }

    public static void removeCity(String city) {
        if (weatherAcrossCities.containsKey(city)) {
            weatherAcrossCities.remove(city);
        } else {
            System.out.println("City does not exist in cache");
        }
    }

    public static void printAllCities() {
        for (WeatherData weatherData : weatherAcrossCities.values()) {
            System.out.println(weatherData);
        }
    }
}
