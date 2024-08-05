package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, WeatherData> weatherMap = new HashMap<>();

    public static void main(String[] args) {
        weatherMap.put("City", new WeatherData("City", 25, 50));
        weatherMap.put("City1", new WeatherData("City1", 35, 30));
        weatherMap.put("City2", new WeatherData("City2", 30, 60));
        weatherMap.put("City3", new WeatherData("City3", 40, 55));

        System.out.println(getWeatherInfo("City"));

        System.out.println(getWeatherInfo("ity"));

        updateWeatherInfo("City3", 41, 56);

        removeWeatherInfo("City");

        printAllWeatherInfo();
    }

    public static WeatherData getWeatherInfo(String city) {
        if (!weatherMap.containsKey(city)) {
            weatherMap.put(city, null);
            Mock.doWork(city);
        }

        return weatherMap.get(city);
    }

    public static void updateWeatherInfo(String city, int temperature, int humidity) {
        System.out.println(weatherMap.get(city)
                .setTemperature(temperature)
                .setHumidity(humidity));
    }

    public static void removeWeatherInfo(String city) {
        weatherMap.remove(city);
    }

    public static void printAllWeatherInfo() {
        for (Map.Entry<String, WeatherData> entry : weatherMap.entrySet()) {
            if (entry.getValue() != null) {
                System.out.println("Key > " + entry.getKey() + " - value > " + entry.getValue());
            }
        }
    }
}
