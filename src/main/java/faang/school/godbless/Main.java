package faang.school.godbless;

import java.util.HashMap;

public class Main {
    private static HashMap<String, WeatherData> cache = new HashMap<>();

    public static void getWeatherByCity(String city) {
        if (cache.containsKey(city)) {
            System.out.println(city + " temp: " + cache.get(city).getTemperature() + " hummidity: " + cache.get(city).getHumidity());
        } else {
            WeatherData newCity = GlobalWeather.getWeather(city);
            cache.put(city, newCity);
            System.out.println(city + " temp: " + newCity.getTemperature() + " hummidity: " + newCity.getHumidity());
        }
    }

    public static void updateWeatherByCity(String city) {
        if (cache.containsKey(city)) {
            WeatherData updatedWeather = GlobalWeather.getWeather(city);
            cache.replace(city, updatedWeather);
        }
    }

    public static void deleteWeatherByCity(String city) {
        cache.remove(city);
    }

    public static void showAllCities() {
        for (String city : cache.keySet()) {
            System.out.println(city);
        }
    }

    public static void main(String[] args) {
        getWeatherByCity("London");
        getWeatherByCity("Boston");
        getWeatherByCity("Cambridge");
        getWeatherByCity("Almaty");

        updateWeatherByCity("London");
        getWeatherByCity("London");
        deleteWeatherByCity("Boston");
        showAllCities();
    }
}
