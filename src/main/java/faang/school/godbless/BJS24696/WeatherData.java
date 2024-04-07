package faang.school.godbless.BJS24696;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class WeatherData {

    private String city;
    private double temperature;
    private double humidity;

    public static WeatherData getWeatherFromCacheOrExternal(String city, Map<String, WeatherData> weatherCache) {
        if (weatherCache.containsKey(city)) {
            System.out.println("Данные о погоде в городе " + city + " найдены в кеше.");
            return weatherCache.get(city);
        } else {
            System.out.println("Запрашиваем данные о погоде в городе " + city + " из внешнего источника.");
            WeatherData weatherData = WeatherService.getWeatherData(city);
            weatherCache.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeatherDataInCache(String city, Map<String, WeatherData> weatherCache) {
        System.out.println("\nОбновляем данные для города " + city + " в кеше.");
        WeatherData updatedWeather = WeatherService.getWeatherData(city);
        weatherCache.put(city, updatedWeather);
    }

    public static void removeWeatherDataFromCache(String city, Map<String, WeatherData> weatherCache) {
        System.out.println("\nУдаление данных о погоде в городе" + city + " из кеша.");
        weatherCache.remove(city);
    }

    public static void printCitiesWithWeather(Map<String, WeatherData> weatherCache) {
        weatherCache.forEach((city, weatherData) -> System.out.println(city + ": " + weatherData));
    }
}
