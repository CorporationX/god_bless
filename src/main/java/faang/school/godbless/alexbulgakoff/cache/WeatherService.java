package faang.school.godbless.alexbulgakoff.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class WeatherService {
    static Map<String, WeatherData> cacheWeather = new HashMap<>();

    MockOutService mock = new MockOutService();

    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        WeatherData weatherNY = new WeatherData("New York", 7, 59);
        WeatherData weatherSaintP = new WeatherData("Saint-Petersburg", -6.1, 89);
        WeatherData weatherMunich = new WeatherData("Munich", 7, 82);
        WeatherData weatherAmsterdam = new WeatherData("Amsterdam", 8, 85);
        WeatherData weatherParis = new WeatherData("Paris", 10, 91);

        cacheWeather.put("New York", weatherNY);
        cacheWeather.put("Amsterdam", weatherAmsterdam);
        cacheWeather.put("Saint-Petersburg", weatherSaintP);
        cacheWeather.put("Paris", weatherParis);
        cacheWeather.put("Munich", weatherMunich);

        System.out.println(weatherService.getWeatherByCity("Amsterdam"));

        System.out.println(weatherService.getAllCityInCache());

        System.out.println(weatherService.getWeatherByCity("Barcelona"));
    }


    public WeatherData getWeatherByCity(String city) {
        if (!cacheWeather.containsKey(city)) {
            cacheWeather.put(city, getOutService(city));
        }

        return cacheWeather.get(city);
    }

    void updateWeatherInfoByCity(String city) {

    }

    public List<String> getAllCityInCache() {
        return new ArrayList<>(cacheWeather.keySet());
    }

    private WeatherData getOutService(String city) {
        return mock.getWeather(city);
    }
}
