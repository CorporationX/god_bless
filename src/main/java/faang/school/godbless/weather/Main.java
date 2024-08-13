package faang.school.godbless.weather;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weather = new HashMap<>();

    public static String getWeather(String city) {
        if (weather.containsKey(city)) {
           return weather.get(city).getWeatherData();
        } else {
            WeatherData newWeatherData = searchForWeather(city);
            weather.put(city, newWeatherData);
            return newWeatherData.getWeatherData();
        }
    }

    //метод-заглушка для имитации запроса к внешнему источнику
    public static WeatherData searchForWeather(String city){
        System.out.println("Searching for weather in " + city + " in external source...");
        return new WeatherData(city, 0, 0);
    }

    //обновление информации в кэше вручную
    public static void updateWeather(String city, int temperature, int humidity){
        weather.put(city, new WeatherData(city, temperature, humidity));
    }

    //обновление информации в кэше с помощью обращения к "внешнему источнику"
    public static void updateWeather(String city){
        WeatherData weatherData = searchForWeather(city);
        weather.put(city, weatherData);
    }

    public static void deleteWeather(String city){
        weather.remove(city);
    }

    public static void printCitiesWhereWeatherIsAvailable() {
        System.out.println("Cities where you can get weather data:");
        int count = 0;
        for (Map.Entry<String, WeatherData> entry : weather.entrySet()) {
            count++;
            System.out.println(count + ". " + entry.getKey());
        }
    }

    public static void main(String[] args) {
        //updating weather data (manually)
        updateWeather("Moscow", 27, 74);
        updateWeather("Saint Petersburg", 20, 84);
        updateWeather("Tokyo", 31, 100);
        updateWeather("New York", 18, 60);
        updateWeather("Amsterdam", 20, 92);
        updateWeather("Rome", 37, 59);
        updateWeather("London", 22, 82);
        updateWeather("Chicago", 26, 91);
        updateWeather("Novosibirsk", 17, 64);
        updateWeather("Berlin", 27, 72);

        printCitiesWhereWeatherIsAvailable();

        //getting weather (available cities)
        System.out.println(getWeather("Moscow"));
        System.out.println(getWeather("London"));

        //getting weather (not available city)
        System.out.println(getWeather("Mexico City"));

        //updating weather data (from external source)
        System.out.println(getWeather("Rome"));
        updateWeather("Rome");
        System.out.println(getWeather("Rome"));

        //removing weather data
        deleteWeather("Chicago");
        printCitiesWhereWeatherIsAvailable();
    }
}
