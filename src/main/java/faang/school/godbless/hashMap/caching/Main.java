package faang.school.godbless.hashMap.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> weatherCache = new HashMap<>();
    public static void main(String[] args) {
        put("Moscow", 22,55);
        put("New York", 27,60);
        put("London", 20,65);
        System.out.println("After initial adding");
        printAllWeather();

        getWeatherByCity("Tokyo");
        System.out.println();
        System.out.println("After getting info from service");
        printAllWeather();

        System.out.println();
        System.out.println("Getting info from cache");
        System.out.println(getWeatherByCity("Tokyo"));

        put("Moscow", 26, 58);
        System.out.println();
        System.out.println("After updating Moscow");
        printAllWeather();

        delete("Moscow");
        System.out.println();
        System.out.println("After deleting Moscow");
        printAllWeather();
    }

    public static WeatherData getWeatherByCity(String city) {
        validateCity(city);
        WeatherData weather = weatherCache.get(city);
        if (weather == null) {
            WeatherData outerWeather = WeatherService.getWeatherByCity(city);
            put(outerWeather);
            return outerWeather;
        }
        return weather;
    }

    private static void put(String city, int temperature, int humidity) {
        validateCity(city);
        weatherCache.put(city, new WeatherData(city, temperature, humidity));
    }

    private static void put(WeatherData weather) {
        weatherCache.put(weather.getCity(), weather);
    }

    private static void delete(String city) {
        validateCity(city);
        WeatherData weather = weatherCache.remove(city);
        if (weather == null) {
            throw new NotFoundException("Weather for " + city + " not found");
        }
    }


    public static void printAllWeather() {
        for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void validateCity(String city) {
        if (city == null || city.isEmpty() || city.isBlank()) {
            throw new IllegalArgumentException("City can`t be empty");
        }
    }
}
