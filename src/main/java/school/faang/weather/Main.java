package school.faang.weather;

import java.util.HashMap;

public class Main {
    private static HashMap<String, WeatherData> weatherInfo = new HashMap<>();

    public static WeatherData weatherInCity(String city) {
        if(weatherInfo.containsKey(city)) {
            return weatherInfo.get(city);
        } else {
            return queryInDb(city);
        }
    }

    public static WeatherData queryInDb(String city) {
        WeatherData weatherData = new WeatherData(city, (double) Math.random() * 10, (double) Math.random()*100);
        weatherInfo.put(city, weatherData);
        return weatherData;
    }

    public static void updateWeatherInfo(String city, Double temp, Double humidity) {
        WeatherData weather = weatherInCity(city);
        weather.setTemperature(temp);
        weather.setHumidity(humidity);
        weatherInfo.remove(city);
        weatherInfo.put(city, weather);
    }

    public static void deleteWeatherInfo(String city) {
        if(weatherInfo.containsKey(city)) {
            weatherInfo.remove(city);
        }
    }

    public static void displayWeatherInfoForAllCity() {
        weatherInfo.values().forEach(System.out::println);
    }
    public static void main(String[] args) {
        System.out.println(weatherInCity("Tomsk"));
        updateWeatherInfo("Tomsk", 20.0, 40.5);
        System.out.println(weatherInCity("Omsk"));
        System.out.println(weatherInCity("Novosibirsk"));
        System.out.println(weatherInCity("Moscow"));
        System.out.println(weatherInCity("Tomsk"));
        deleteWeatherInfo("Moscow");
        displayWeatherInfoForAllCity();
    }
}