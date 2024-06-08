package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherOfCity = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(forecastOf("Saint-Petersburg"));
        System.out.println(forecastOf("Moscow"));
        System.out.println(forecastOf("Amsterdam"));

        updateForecast("Mosow");
        updateForecast("Moscow");

        removeForecast("Amsrdam");
        removeForecast("Amsterdam");
        printAllCities();
    }

    public static WeatherData forecastOf(String city) {
        if (weatherOfCity.containsKey(city)) return weatherOfCity.get(city);
        else {
            WeatherService weather = WeatherService.getForecast(city);
            weatherOfCity.put(city, new WeatherData(weather.getCity(), weather.getTemperature(), weather.getHumidity()));
            return new WeatherData(weather.getCity(), weather.getTemperature(), weather.getHumidity());
        }
    }

    public static void updateForecast(String city) {
        if (weatherOfCity.containsKey(city)) {
            WeatherService weather = WeatherService.getForecast(city);
            weatherOfCity.put(city, new WeatherData(weather.getCity(), weather.getTemperature(), weather.getHumidity()));
        } else System.out.println("There is no weather of the " + city);
    }

    public static void removeForecast(String city) {
        if (weatherOfCity.containsKey(city)) weatherOfCity.remove(city);
        else System.out.println("There is already no weather of the " + city);
    }

    public static void printAllCities() {
        for (String city : weatherOfCity.keySet()) System.out.println(city);
    }
}