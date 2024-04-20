package faang.school.godbless.cache_cache;

import java.util.HashMap;

public class Main {
    private static final HashMap<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        weatherCache.put("Москва", new WeatherData("Москва", 15, 60));
        weatherCache.put("Санкт-Петербург", new WeatherData("Санкт-Петербург", 10, 70));
        weatherCache.put("Нью-Йорк", new WeatherData("Нью-Йорк", 20, 50));

        getAllCities();

        getWeatherByCity("Грузия");

        updateWeatherByCity("Москва", 20, 50);

        removeWeatherByCity("Нью-Йорк");

        getAllCities();
    }

    public static void getWeatherByCity(String city) {
        if (weatherCache.containsKey(city)) {
            System.out.println(weatherCache.get(city));
        } else {
            WeatherData weather = WeatherService.getWeather(city);
            weatherCache.put(weather.getCity(), weather);
            System.out.println(weather);
        }
    }

    public static void updateWeatherByCity(String city, int temperature, int humidity) {
        if (weatherCache.containsKey(city)) {
            WeatherData updateData = new WeatherData(city, temperature, humidity);
            weatherCache.put(city, updateData);
            System.out.println("Погода в городе " + city + " обновлена ");
        } else {
            System.out.println("Город не найден");
        }
    }

    public static void removeWeatherByCity(String city) {
        if (weatherCache.containsKey(city)) {
            weatherCache.remove(city);
            System.out.println("Город " + city + " удален ");
        } else {
            System.out.println("Город не найден");
        }
    }

    public static void getAllCities() {
        if (weatherCache.isEmpty()) {
            System.out.println("Список пуст ");
        } else {
            for (String city : weatherCache.keySet()) {
                System.out.println(city);
            }
        }
    }
}
