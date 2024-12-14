package school.faang.caching;

import java.util.HashMap;
import java.util.Map;

public class Service {

    private static final Map<String, WeatherData> WEATHER_CASHE = new HashMap<>();
    private WeatherDateService weatherDateService = new WeatherDateService();

    public WeatherData getWeather(String city) {
        if (WEATHER_CASHE.containsKey(city)) {
            return WEATHER_CASHE.get(city);
        } else {
            WeatherData weatherData = weatherDateService.fetchWeather(city);
            WEATHER_CASHE.put(city, weatherData);
            return weatherData;
        }
    }

    public void updateWeatherDate(String city, WeatherData weatherData) {
        WEATHER_CASHE.put(city, weatherData);
    }

    public void removeWeatherDate(String city) {
        WEATHER_CASHE.remove(city);
    }

    public void listCity() {
        System.out.println("Список городов с доступной информацией о погоде");
        for (String city : WEATHER_CASHE.keySet()) {
            System.out.println(city);
        }
    }
}
