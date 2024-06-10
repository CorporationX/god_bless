package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static ExternalSource externalSource = new ExternalSource();
    private static Map<String, WeatherData> cachedWeatherDataByCityName
            = new HashMap<>();

    public static void main(String[] args) {
        //TestGetSameCityDataTwice
        System.out.println(getWeatherData("1"));
        System.out.println(getWeatherData("1"));

        //TestGetUpdatedData
        update("1", 24.6, 51.4);
        System.out.println(getWeatherData("1"));


        //TestGetNamesCachedData
        getWeatherData("2");
        getWeatherData("3");
        System.out.println(getCachedCityNames());

        //TestDeleteData
        System.out.println(cachedWeatherDataByCityName);
        delete("1");
        System.out.println(cachedWeatherDataByCityName);
    }

    // Получаем данные из кэша,
    // а при отсутствии запрашиваем их из внешного источника
    static WeatherData getWeatherData(String cityName) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cant be NULL");
        }

        return cachedWeatherDataByCityName.computeIfAbsent(
                cityName, key -> externalSource.getWeatherData(cityName));
    }

    // Получаем список всех городов, для которых есть информация в кэше.
    static List<String> getCachedCityNames() {
        return cachedWeatherDataByCityName.keySet().stream().toList();
    }

    // Обновляем данные кэша
    static void update(String cityName, double temp, double humidity) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cant be NULL");
        }

        WeatherData weatherData = cachedWeatherDataByCityName.get(cityName);
        weatherData.setTemperature(temp);
        weatherData.setHumidity(humidity);
    }

    // Удаляем данные кэша
    static void delete(String cityName) {
        if (cityName == null) {
            throw new IllegalArgumentException("City name cant be NULL");
        }

        cachedWeatherDataByCityName.remove(cityName);
    }
}
