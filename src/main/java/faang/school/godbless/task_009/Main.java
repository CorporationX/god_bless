package faang.school.godbless.task_009;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static Map<String, WeatherData> weatherDataMap;

    public static void main(String[] args) {

        System.out.println("Добавляем в хэш данные о погоде в Москве");
        weatherDataMap = new HashMap<>();
        String city1 = "Moscow";
        weatherDataMap.put(city1, WeatherService.getWeather(city1));

        System.out.println();
        System.out.println("Добавляем в хэш данные о погоде во Владимире");
        String city2 = "Vladimir";

        System.out.println();
        System.out.println("Погода во Владимире");
        System.out.println(getWeatherInfo(city2));

        System.out.println();
        System.out.println("Обновляем данные о погоде во Владимире");
        updateWeather(city2);

        System.out.println();
        System.out.println("Погода во Владимире(обновлённая");
        System.out.println(getWeatherInfo(city2));

        System.out.println();
        System.out.println("Список городов с погодой в хэш");
        showListCity();

        System.out.println();
        System.out.println("Удаляем из хэша данные по Москве");
        deleteWeatherDate(city1);

        System.out.println();
        System.out.println("Список городов с погодой в хэш (после удаления)");
        showListCity();
    }

    private static void showListCity() {
        weatherDataMap.keySet().forEach(System.out::println);
    }

    /**
     * Удаление данных о погоде
     *
     * @param city
     */
    private static void deleteWeatherDate(String city) {
        weatherDataMap.remove(city);
    }

    /**
     * Получение информации о погоде в городе.
     * Если в хэще отстутствуют данные, то обращаемся к сервесу за их получением.
     *
     * @param city
     * @return
     */
    private static String getWeatherInfo(String city) {
        if (weatherDataMap.containsKey(city)) {
            return weatherDataMap.get(city).toString();
        } else {
            WeatherData weatherData = WeatherService.getWeather(city);
            weatherDataMap.put(city, weatherData);
            return weatherData.toString();
        }
    }

    /**
     * Обновление данных о погоде.
     *
     * @param city
     */
    public static void updateWeather(String city) {
        if (weatherDataMap.containsKey(city)) {
            weatherDataMap.put(city, WeatherService.getWeather(city));
        }
    }


}

/**
 * Сервис для получения данных о погоде
 */
class WeatherService {
    public static WeatherData getWeather(String city) {
        Random rand = new Random();
        return new WeatherData(city, rand.nextDouble(40), rand.nextInt(20, 80));
    }
}
