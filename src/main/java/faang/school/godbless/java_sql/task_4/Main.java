package faang.school.godbless.java_sql.task_4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, WeatherData> cache = getCache();
        System.out.println(WeatherController.getTemperatureFromCity(cache, "New York"));
        System.out.println(WeatherController.getTemperatureFromCity(cache, "Prague"));
        System.out.println("------------------------");
        WeatherController.deleteTemperatureByCity(cache, "Phoenix");
        WeatherController.printTemperatureCache(cache);
        System.out.println("------------------------");
        var updatedWeather = new WeatherData("Houston", 20, 70);
        WeatherController.updateTemperatureByWeather(cache, updatedWeather);
        System.out.println(WeatherController.getTemperatureFromCity(cache, updatedWeather.city()));
    }

    static HashMap<String, WeatherData> getCache() {
        HashMap<String, WeatherData> cache = new HashMap<>();
        var firstWeatherData = new WeatherData("New York", 15, 70);
        var secondWeatherData = new WeatherData("Los Angeles", 25, 65);
        var thirdWeatherData = new WeatherData("Chicago", 10, 80);
        var fourthWeatherData = new WeatherData("Houston", 30, 85);
        var fifthWeatherData = new WeatherData("Phoenix", 35, 20);
        cache.put(firstWeatherData.city(), firstWeatherData);
        cache.put(secondWeatherData.city(), secondWeatherData);
        cache.put(thirdWeatherData.city(), thirdWeatherData);
        cache.put(fourthWeatherData.city(), fourthWeatherData);
        cache.put(fifthWeatherData.city(), fifthWeatherData);
        return cache;
    }
}
