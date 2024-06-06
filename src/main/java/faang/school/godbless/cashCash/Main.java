package faang.school.godbless.cashCash;

import java.util.HashMap;

public class Main {
    private static HashMap<String, WeatherData> gorodWeatherData = new HashMap<>();

    public static void main(String args[]) {
        addWeather(new WeatherData("Moscow", 20, 75));
        addWeather(new WeatherData("New York", 30, 60));
        addWeather(new WeatherData("France", 35, 45));
        addWeather(new WeatherData("Afrika", 25, 66));
        addWeather(new WeatherData("Moscow", 30, 56));


        System.out.println(getWeatherOfCity("France"));
        System.out.println(getWeatherOfCity("Chily"));

        System.out.println(updateWeather("Chily", new WeatherData("New York", 70, 90)));


    }

    public static void addWeather(WeatherData weatherData) {
        if (weatherData != null) {
            gorodWeatherData.put(weatherData.getCity(), weatherData);
        }
    }
    public static String getWeatherOfCity(String city) {
        if(!city.isBlank()) {
            if (!gorodWeatherData.containsKey(city)) {
                addWeather(WeatherSourceService.getWeatherData(city));
            }
            return ("Город: " + gorodWeatherData.get(city).getCity() + " , " +
                    "Температура: " + gorodWeatherData.get(city).getTemperature() + " , " +
                    "Влажность: " + gorodWeatherData.get(city).getHumidity());
        }else{
            throw new IllegalArgumentException("Неправильное значение!");
        }
    }
    public static String updateWeather(String city, WeatherData weatherData){
        if(!city.isBlank()) {
            gorodWeatherData.get(city).setTemperature(weatherData.getTemperature());
            gorodWeatherData.get(city).setHumidity(weatherData.getHumidity());

            return ("Город: " + gorodWeatherData.get(city).getCity() + " , " +
                    "Температура: " + gorodWeatherData.get(city).getTemperature() + " , " +
                    "Влажность: " + gorodWeatherData.get(city).getHumidity());
        }else{
            throw new IllegalArgumentException("Неправильное значение!");
        }
    }
}