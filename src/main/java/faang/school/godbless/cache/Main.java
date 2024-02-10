package faang.school.godbless.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, WeatherData> weatherForecast = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weatherDataNY = new WeatherData("NY", 30, 15);
        WeatherData weatherDataNSK = new WeatherData("NSK", 20, 25);
        WeatherData weatherDataMSK = new WeatherData("MSK", 21, 30);
        WeatherData weatherDataEKB = new WeatherData("EKB", 30, 15);
        weatherForecast.put("New york", weatherDataNY);
        weatherForecast.put("Novosibirsk", weatherDataNSK);
        weatherForecast.put("Moscow", weatherDataMSK);
        weatherForecast.put("Yekaterinburg", weatherDataEKB);
        deleteWeatherInfo("New york");
        listWeather();
    }

    public static void getWeather(String city) {
        if (weatherForecast.containsKey(city)) {
            System.out.println(weatherForecast.get(city));
        } else {
            weatherForecast.put(city, OpenResource.searchForWeather(city));
        }
    }

    public static void updateWeatherInCache(String city, WeatherData weather) {
        weatherForecast.put(city, weather);
    }

    public static void deleteWeatherInfo(String city) {
        weatherForecast.remove(city);
    }

    public static void listWeather() {
        for (WeatherData weather : weatherForecast.values()) {
            System.out.println(weather);
        }
    }

}
