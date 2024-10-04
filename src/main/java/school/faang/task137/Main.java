package school.faang.task137;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HashMap<String, WeatherData> CITY_WEATHER = new HashMap<>();

    public static WeatherData getWeather(String cityName) {
        if (CITY_WEATHER.containsKey(cityName)) {
            return CITY_WEATHER.get(cityName);
        }
        WeatherData dataFromService = Mock.getWeather(cityName);
        CITY_WEATHER.put(cityName, dataFromService);
        return getWeather(cityName);
    }

    public static void updateInfo(String cityName, int temperature, double humidity) {
        if (CITY_WEATHER.containsKey(cityName)) {
            CITY_WEATHER.get(cityName).setTemperature(temperature);
            CITY_WEATHER.get(cityName).setHumidity(humidity);
        }
    }

    public static void removeWeatherData(String cityName) {
        CITY_WEATHER.remove(cityName);
    }

    public static void printAllCityFromCache() {
        for (Map.Entry<String, WeatherData> entry : CITY_WEATHER.entrySet()) {
            System.out.println(entry.getKey() + "\t"
                    + "Температура: " + entry.getValue().getTemperature() + " C" + "\t"
                    + "Влажность: " + entry.getValue().getHumidity() + " %");
        }
    }

    public static void main(String[] args) {
        WeatherData samara = new WeatherData("Samara", 6, 50);
        WeatherData moscow = new WeatherData("Moscow", 11, 99);
        WeatherData london = new WeatherData("London", 11, 97);

        CITY_WEATHER.put(samara.getCity(), samara);
        CITY_WEATHER.put(moscow.getCity(), moscow);
        CITY_WEATHER.put(london.getCity(), london);

        printAllCityFromCache();
        System.out.println();

        System.out.println(getWeather(samara.getCity()).getTemperature());
        System.out.println();

        updateInfo(samara.getCity(), 15, 56);
        printAllCityFromCache();
        System.out.println();

        removeWeatherData(samara.getCity());
        printAllCityFromCache();
    }
}
