package faang.school.godbless.javahashmap.task4;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HashMap<String, WeatherData> weatherDataMap = new HashMap<>();
    private static final WeatherInfo weatherInfo = new WeatherInfo();
    public static void main(String[] args) {

        getWeatherData("London");
        getWeatherData("Paris");
        getWeatherData("New York");
        getWeatherData("Tokyo");
        getWeatherData("Moscow");

        printAllWeatherData();
        System.out.println();

        removeWeatherData("New York");
        removeWeatherData("Paris");
        printAllWeatherData();
        System.out.println();

        updateWeatherData("Moscow");
        updateWeatherData("Tokyo");
        printAllWeatherData();
    }

    public static WeatherData getWeatherData(String city) {
        if (weatherDataMap.containsKey(city)) {
            return weatherDataMap.get(city);
        } else {
            WeatherData weatherData = weatherInfo.getWeatherInfo(city);
            weatherDataMap.put(city, weatherData);
            return weatherData;
        }
    }

    public static WeatherData updateWeatherData(String city) {
        if (!weatherDataMap.containsKey(city)) {
            WeatherData weatherData = weatherInfo.getWeatherInfo(city);
            weatherDataMap.put(city, weatherData);
            return weatherData;
        } else {
            WeatherData currentWeatherData = weatherInfo.getWeatherInfo(city);
            return weatherDataMap.put(city, currentWeatherData);
        }
    }

    public static WeatherData removeWeatherData(String city) {
        if (weatherDataMap.containsKey(city)) {
            return weatherDataMap.remove(city);
        }
        return null;
    }

    public static void printAllWeatherData() {
        for (Map.Entry<String, WeatherData>  entry : weatherDataMap.entrySet()) {
            System.out.println("Город " + entry.getKey() + " " + entry.getValue());
        }
    }
}
