package school.faang.JavaHashMap.BJS2_32560;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> cityWeather = new HashMap<>();
    private static final WeatherService weatherService = new WeatherService();

    public static void main(String[] args) {
        System.out.println("Получение данных о погоде:");
        System.out.println(weatherData("Москва"));
        System.out.println(weatherData("Санкт-Петербург"));

        System.out.println("\nВывод всех городов в кэше:");
        printAllCitiesWeatherInfo();

        System.out.println("\nОбновление информации о погоде:");
        WeatherData updatedData = new WeatherData("Москва", 25, 60);
        updateWeatherInfo(updatedData);
        System.out.println(weatherData("Москва"));

        System.out.println("\nУдаление информации о погоде:");
        removeWeatherInfo("Санкт-Петербург");

        System.out.println("\nПовторный вывод всех городов в кэше:");
        printAllCitiesWeatherInfo();
    }

    public static String weatherData(String cityName) {
        WeatherData data = cityWeather.computeIfAbsent(cityName, weatherService::getWeatherData);
        return data.toString();
    }

    public static void updateWeatherInfo(WeatherData weatherInfo) {
        if (weatherInfo == null || weatherInfo.getCity() == null || weatherInfo.getCity().isEmpty()) {
            throw new IllegalArgumentException("WeatherInfo или город не может быть null или пустым");
        }
        cityWeather.put(weatherInfo.getCity(), weatherInfo);
    }

    public static void removeWeatherInfo(String cityName) {
        if (cityName == null || cityName.isEmpty()) {
            throw new IllegalArgumentException("Название города не может быть null или пустым");
        }
        cityWeather.remove(cityName);
    }

    public static void printAllCitiesWeatherInfo() {
        if (cityWeather.isEmpty()) {
            System.out.println("Кэш погоды пуст");
            return;
        }
        for (WeatherData weatherData : cityWeather.values()) {
            System.out.println(weatherData);
        }
    }
}

