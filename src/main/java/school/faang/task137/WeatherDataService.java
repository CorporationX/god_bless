package school.faang.task137;

import java.util.HashMap;
import java.util.Map;

public class WeatherDataService {

    private static final HashMap<String, WeatherData> cityWeather = new HashMap<>();

    public static WeatherData getWeather(String cityName) {
        if (cityWeather.containsKey(cityName)) {
            return cityWeather.get(cityName);
        }
        WeatherData dataFromService = Mock.getWeather(cityName);
        cityWeather.put(cityName, dataFromService);
        return getWeather(cityName);
    }

    public static void updateInfo(String cityName, int temperature, double humidity) {
        if (cityWeather.containsKey(cityName)) {
            cityWeather.get(cityName).setTemperature(temperature);
            cityWeather.get(cityName).setHumidity(humidity);
        }
    }

    public static void removeWeatherData(String cityName) {
        cityWeather.remove(cityName);
    }

    public static void putWeather(String cityName, WeatherData weatherData) {
        cityWeather.put(cityName, weatherData);
    }

    public static void printAllCityFromCache() {
        for (Map.Entry<String, WeatherData> entry : cityWeather.entrySet()) {
            System.out.println(entry.getKey() + "\t"
                    + "Температура: " + entry.getValue().getTemperature() + " C" + "\t"
                    + "Влажность: " + entry.getValue().getHumidity() + " %");
        }
    }

}
