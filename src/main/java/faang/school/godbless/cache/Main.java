package faang.school.godbless.cache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static HashMap<String, WeatherData> weatherCache;
    private static ExternalService externalService;

    public static void getWeatherByCity(String city) {
        if (!weatherCache.containsKey(city)) {
            weatherCache.put(city, externalService.getWeatherData(city));
        }
        WeatherData weatherData = weatherCache.get(city);
        System.out.println("City: " + weatherData.getCity() + ", temperature: " +
                weatherData.getTemperature() + ", humidity:  " + weatherData.getHumidity());
    }

    public static void updateWeatherInfo(String city, int temperature, int humidity) {
        if (weatherCache.containsKey(city)) {
            WeatherData weatherData = weatherCache.get(city);
            weatherData.setTemperature(temperature);
            weatherData.setHumidity(humidity);
        }
    }

    public static void deleteWeatherInfo(String city) {
        weatherCache.remove(city);
    }

    public static void getAllWeatherInfo() {
        for (Map.Entry<String, WeatherData> entry : weatherCache.entrySet()) {
            WeatherData weatherData = entry.getValue();
            System.out.println("City: " + entry.getKey() + ", temperature: " +
                    weatherData.getTemperature() + ", humidity:  " + weatherData.getHumidity());
        }
    }

    public static void main(String[] args) {

        weatherCache = new HashMap<>();
        externalService = new ExternalService();

        weatherCache.put("SPB", new WeatherData("SPB", -2, 90));
        weatherCache.put("Kemer", new WeatherData("Kemer", 40, 56));
        weatherCache.put("Tokyo", new WeatherData("Tokyo", 15, 90));

        getWeatherByCity("London");
        getWeatherByCity("Moscow");
        System.out.println();
        getAllWeatherInfo();
        System.out.println();
        updateWeatherInfo("Moscow", 10, 50);
        getWeatherByCity("Moscow");
        System.out.println();
        getAllWeatherInfo();
        deleteWeatherInfo("London");
        System.out.println();
        getAllWeatherInfo();

    }
}
