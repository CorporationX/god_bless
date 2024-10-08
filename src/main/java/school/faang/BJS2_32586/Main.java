package school.faang.BJS2_32586;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Main {
    private static final Map<City, WeatherData> WEATHER_CACHE = new HashMap<>();
    private static final Random RANDOM = new Random();

    private static boolean checkContentsInCache(City cityName) {
        return WEATHER_CACHE.containsKey(cityName);
    }

    public static WeatherData getWeatherData(City cityName) {
        if (checkContentsInCache(cityName)) {
            return WEATHER_CACHE.get(cityName);
        } else {
            WeatherData weatherData = fetchWeatherDataFromExternalAPI(cityName);

            WEATHER_CACHE.put(cityName, weatherData);

            return weatherData;
        }
    }

    private static WeatherData fetchWeatherDataFromExternalAPI(City cityName) {
        City[] cities = City.values();
        int temperature = RANDOM.nextInt(-20, 30);
        int humidity = RANDOM.nextInt(0, 80);

        for (City city : cities) {
            if (city.name().equalsIgnoreCase(cityName.name())) {
                return new WeatherData(city, temperature, humidity);
            }
        }

        return null;
    }

    public static void updateWeatherData(City cityName, int temperature, int humidity) {
        if (!checkContentsInCache(cityName)) {
            System.out.println("Город " + cityName.name() + " не найден в кэше");
        } else {
            WEATHER_CACHE.putIfAbsent(cityName, new WeatherData(cityName, temperature, humidity));
        }
    }

    public static void removeWeatherData(City cityName) {
        if (checkContentsInCache(cityName)) {
            WEATHER_CACHE.remove(cityName);
        } else {
            System.out.println("Город " + cityName.name() + " не найден в кэше");
        }
    }

    public static void getAllWeatherData() {
        if (!WEATHER_CACHE.isEmpty()) {
            for (WeatherData data : WEATHER_CACHE.values()) {
                System.out.println(data);
            }
        } else {
            System.out.println("The cache is empty!");
        }
    }

    public static void addData(WeatherData weatherData) {
        if (Objects.nonNull(weatherData)) {
            WEATHER_CACHE.put(weatherData.getCity(), weatherData);
        }
    }

    public static void main(String[] args) {
        WeatherData weatherInHamburg = new WeatherData(City.HAMBURG, 15, 45);
        WeatherData weatherInPrague = new WeatherData(City.PRAGUE, 22, 20);
        WeatherData weatherInBarcelona = new WeatherData(City.BARCELONA, 25, 40);

        addData(weatherInHamburg);
        addData(weatherInPrague);
        addData(weatherInBarcelona);

        getAllWeatherData();
        System.out.println();

        System.out.println(getWeatherData(City.BERLIN));
        System.out.println();

        updateWeatherData(City.HAMBURG, 17, 36);
        System.out.println(getWeatherData(City.HAMBURG));
        System.out.println();

        removeWeatherData(City.HAMBURG);

        getAllWeatherData();
    }
}