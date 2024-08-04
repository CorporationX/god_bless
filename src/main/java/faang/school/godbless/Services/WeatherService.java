package faang.school.godbless.Services;

import faang.school.godbless.Main;
import faang.school.godbless.models.WeatherData;

import java.util.Random;

import static faang.school.godbless.Main.weatherForecastMap;

public class WeatherService {

    public static WeatherData getWeatherForecastByCity(String city) {

        WeatherData weatherData = new WeatherData(city,
                new Random().nextFloat(-30f, 31f),
                new Random().nextInt(0, 101));

        Main.getWeatherForecastMap().put(weatherData.getCity(), weatherData);
        return weatherData;
    }

    public static void infoWeatherByCity(String city) {
        weatherForecastMap.entrySet().stream()
                .filter(e -> e.getValue().getCity().equalsIgnoreCase(city))
                .findFirst()
                .ifPresentOrElse(c -> System.out.println(c.getValue()),
                        () -> System.out.println(getWeatherForecastByCity(city)));
    }

    public static void updateWeatherCacheByCity(String city) {
        if (weatherForecastMap.containsKey(city)) {
            getWeatherForecastByCity(city);
        } else {
            System.out.println("Not found " + city + " for update");
        }
    }

    public static void deleteWeatherCacheByCity(String city) {
        weatherForecastMap.remove(city);
    }

    public static void printAvailableCitiesInWeatherCache() {
        System.out.println(String.join(", ", weatherForecastMap.keySet()));
    }
}
