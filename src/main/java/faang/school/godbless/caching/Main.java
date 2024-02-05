package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, WeatherData> citiesWeathers = new HashMap<>() {{
        put("City1", new WeatherData("City1", 25, 70));
        put("City2", new WeatherData("City2", 20, 80));
        put("City3", new WeatherData("City3", 30, 60));
    }};

    public static void main(String[] args) {
        WeatherData weatherData = getWeatherData("City3");
        System.out.println(weatherData.getTemperature() + " " + weatherData.getHumidity());

        updateWeatherData("City2", new WeatherData("City2",5, 8));
        weatherData = getWeatherData("City2");
        System.out.println(weatherData.getTemperature() + " " + weatherData.getHumidity());

        deleteWeatherData("City1");
        printAllCitiesInCache();
    }

    public static WeatherData getWeatherData(String cityName) {
        WeatherData weatherData = citiesWeathers.get(cityName);
        if (weatherData == null) {
            weatherData = MockService.pullWeatherData();
            citiesWeathers.put(cityName, weatherData);
        }
        return weatherData;
    }

    public static void updateWeatherData(String cityName, WeatherData weatherData) {
        citiesWeathers.put(cityName, weatherData);
    }

    public static void deleteWeatherData(String cityName) {
        citiesWeathers.remove(cityName);
    }

    public static void printAllCitiesInCache() {
        for (var key : citiesWeathers.keySet()) {
            System.out.println(key);
        }
    }
}
