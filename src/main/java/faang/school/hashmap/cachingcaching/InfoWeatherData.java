package faang.school.hashmap.cachingcaching;

import java.util.HashMap;
import java.util.Map;

public class InfoWeatherData {

    private final Map<String, WeatherData> weatherData = new HashMap<>();

    private void completionMapData() {
        WeatherData grodno = new WeatherData("Grodno", 22, 80);
        WeatherData minst = new WeatherData("Minsk", 20, 88);
        WeatherData brest = new WeatherData("Brest", 21, 90);
        WeatherData vitebsk = new WeatherData("Vitebsk", 25, 87);
        WeatherData gomel = new WeatherData("Gomel", 19, 80);
        WeatherData mogilev = new WeatherData("Mogilev", 20, 86);

        weatherData.put("Grodno", grodno);
        weatherData.put("Minsk", minst);
        weatherData.put("Brest", brest);
        weatherData.put("Vitebsk", vitebsk);
        weatherData.put("Gomel", gomel);
        weatherData.put("Mogilev", mogilev);
    }

    public WeatherData checkingWeatherDataCache(String city) {
        if (city != null && !city.isBlank()) {
            completionMapData();
            if (weatherData.containsKey(city)) {
                return weatherData.get(city);
            } else {
                System.out.println("Не существует такого города " + city);
            }
        }
        return null;
    }
}
