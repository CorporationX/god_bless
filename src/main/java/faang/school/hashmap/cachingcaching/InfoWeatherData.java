package faang.school.hashmap.cachingcaching;

import java.util.HashMap;

public class InfoWeatherData {

    private final HashMap<String, WeatherData> mapWeatherData = new HashMap<>();

    private void completionMapData() {
        WeatherData grodno = new WeatherData("Grodno", 22, 80);
        WeatherData minst = new WeatherData("Minsk", 20, 88);
        WeatherData brest = new WeatherData("Brest", 21, 90);
        WeatherData vitebsk = new WeatherData("Vitebsk", 25, 87);
        WeatherData gomel = new WeatherData("Gomel", 19, 80);
        WeatherData mogilev = new WeatherData("Mogilev", 20, 86);

        mapWeatherData.put("Grodno", grodno);
        mapWeatherData.put("Minsk", minst);
        mapWeatherData.put("Brest", brest);
        mapWeatherData.put("Vitebsk", vitebsk);
        mapWeatherData.put("Gomel", gomel);
        mapWeatherData.put("Mogilev", mogilev);
    }

    public WeatherData weatherData(String city) {
        if (!(city.isBlank())) {
            completionMapData();
            if (mapWeatherData.containsKey(city)) {
                return mapWeatherData.get(city);
            } else {
                System.out.println("Не существует такого города " + city);
            }
        }
        return null;
    }
}
