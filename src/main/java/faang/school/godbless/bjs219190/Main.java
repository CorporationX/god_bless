package faang.school.godbless.bjs219190;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherData = new HashMap<>();
        System.out.println(WeatherDataManager.getWeatherData(weatherData, "Madrid"));
        System.out.println(WeatherDataManager.getWeatherData(weatherData, "Valencia"));
        System.out.println(WeatherDataManager.getWeatherData(weatherData, "Valladolid"));
        System.out.println(WeatherDataManager.getWeatherData(weatherData, "Madrid"));
        WeatherDataManager.updateWeatherData(weatherData, "Valladolid");
        WeatherDataManager.deleteWeatherData(weatherData, "Valencia");
        WeatherDataManager.printWeatherData(weatherData);
    }
}
