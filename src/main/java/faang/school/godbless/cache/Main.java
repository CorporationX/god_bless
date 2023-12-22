package faang.school.godbless.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<String, WeatherData> cities = new HashMap<>();
    public static void main(String[] args) {
        cities.put("New York", new WeatherData("New York", 20, 65));
        cities.put("London", new WeatherData("London", 18, 70));
        cities.put("Tokyo", new WeatherData("Tokyo", 28, 80));
        getAllCities();

        updateWeatherData("New York", 2131312312, 31232131);
        System.out.println("______________________________");
        getAllCities();

        deleteWeatherData("London");
        System.out.println("______________________________");
        getAllCities();
    }

    public static WeatherData getWeatherData(String city) {
        WeatherData cityWeatherDataCache = cities.get(city);
        if (cityWeatherDataCache == null) {
            WeatherData cityWeatherData = WeatherService.fetchWeatherData(city);
            cities.put(city, cityWeatherData);
            return cityWeatherData;
        }

        return cityWeatherDataCache;
    }

    public static void updateWeatherData(String city, int temperature, int humidity) {
        WeatherData cityWeatherData = cities.get(city);
        if (cityWeatherData == null) {
            System.out.println("Data not found");
        } else {
            cityWeatherData.setTemperature(temperature);
            cityWeatherData.setHumidity(humidity);
        }
    }

    public static void deleteWeatherData(String city) {
        WeatherData cityWeatherData = cities.get(city);
        if (cityWeatherData == null) {
            System.out.println("Data not found");
        } else {
            cities.remove(city);
        }
    }

    public static void getAllCities() {
        cities.keySet().forEach(city -> System.out.println(getWeatherData(city)));
    }
}
