package faang.school.godbless.hashmap4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CACHE_WEATHER = new HashMap<>();
    private static final String ERROR = "Такого города нет в базе";

    public static void main(String[] args) {
        CACHE_WEATHER.put("Msk", new WeatherData("Msk", 21, 15));
        CACHE_WEATHER.put("Spb", new WeatherData("Spb", 15, 10));
        CACHE_WEATHER.put("NN", new WeatherData("NN", 19, 13));
        CACHE_WEATHER.put("Orel", new WeatherData("Orel", 23, 15));

        System.out.println(getWeather("Msk").toString());
        System.out.println(getWeather("Tula").toString());
        updateWeather("Msk", 10, 5);
        System.out.println(getWeather("Msk").toString());
        deleteDataFromBase("Belgorod");
        deleteDataFromBase("NN");
        displayCache();
    }

    public static WeatherData getWeather(String city) {
        if (CACHE_WEATHER.containsKey(city)) {
            return CACHE_WEATHER.get(city);
        } else {
            getWeatherMoc();
            CACHE_WEATHER.put(city, new WeatherData(city, 10, 10));
            return CACHE_WEATHER.get(city);
        }
    }

    private static void getWeatherMoc() {
    }

    public static void updateWeather(String city, int temperature, int humidity) {
        if (CACHE_WEATHER.containsKey(city)) {
            WeatherData weatherData = CACHE_WEATHER.get(city);
            weatherData.setTemperature(temperature);
            weatherData.setHumidity(humidity);
        } else {
            System.out.println(ERROR);
        }
    }

    public static void deleteDataFromBase(String city) {
        if (CACHE_WEATHER.containsKey(city)) {
            CACHE_WEATHER.remove(city);
        } else {
            System.out.println(ERROR);
        }
    }

    public static void displayCache() {
        for (Map.Entry<String, WeatherData> entry : CACHE_WEATHER.entrySet()) {
            System.out.printf("%s : темпиратура - %s, влажность - %s%n",
                    entry.getKey(), entry.getValue().getTemperature(), entry.getValue().getHumidity());
        }
    }
}
