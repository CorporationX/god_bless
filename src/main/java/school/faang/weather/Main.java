package school.faang.weather;

import java.util.HashMap;
import java.util.Random;

public class Main {
    private static HashMap<String, WeatherData> weatherInfo = new HashMap<>();
    private static final Integer MAX_TEMP = 50;
    private static final Integer MAX_HUMIDITY = 100;

    public static WeatherData getWeatherInCity(String city) {
        return weatherInfo.containsKey(city) ? weatherInfo.get(city) : queryInDb(city);
    }

    public static WeatherData queryInDb(String city) {
        Random rnd = new Random();
        WeatherData weatherData = new WeatherData(city, rnd.nextDouble(MAX_TEMP), rnd.nextDouble(MAX_HUMIDITY));
        weatherInfo.put(city, weatherData);
        return weatherData;
    }

    public static void updateWeatherInfo(String city, Double temp, Double humidity) {
        WeatherData weather = getWeatherInCity(city);
        weather.setTemperature(temp);
        weather.setHumidity(humidity);
        weatherInfo.remove(city);
        weatherInfo.put(city, weather);
    }

    public static void deleteWeatherInfo(String city) {
        weatherInfo.remove(city);
    }

    public static void displayWeatherInfoForAllCity() {
        weatherInfo.values().forEach(System.out::println);
    }
    public static void main(String[] args) {
        System.out.println(getWeatherInCity("Tomsk"));
        updateWeatherInfo("Tomsk", 20.0, 40.5);
        System.out.println(getWeatherInCity("Omsk"));
        System.out.println(getWeatherInCity("Novosibirsk"));
        System.out.println(getWeatherInCity("Moscow"));
        System.out.println(getWeatherInCity("Tomsk"));
        deleteWeatherInfo("Moscow");
        displayWeatherInfoForAllCity();
    }
}