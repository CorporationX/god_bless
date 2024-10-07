package school.faang.BJS2_32586;


import java.util.*;

public class Main {
    private static final Map<String, WeatherData> WEATHER_CACHE = new HashMap<>();
    private static final Random RANDOM = new Random();

    private static boolean checkContentsInCache(String cityName) {
        return WEATHER_CACHE.containsKey(cityName);
    }

    public static WeatherData getWeatherData(String cityName) {
        if (checkContentsInCache(cityName)) {
            return WEATHER_CACHE.get(cityName);
        } else {
            WeatherData weatherData = fetchWeatherDataFromExternalAPI(cityName);

            WEATHER_CACHE.put(cityName, weatherData);

            return weatherData;
        }
    }

    private static WeatherData fetchWeatherDataFromExternalAPI(String cityName) {
        City[] cities = City.values();
        int temperature = RANDOM.nextInt(-20, 30);
        int humidity = RANDOM.nextInt(0, 80);

        for (City city : cities) {
            if (city.name().equalsIgnoreCase(cityName)) {
                return new WeatherData(city.name(), temperature, humidity);
            }
        }

        return null;
    }

    public static void updateWeatherData(String cityName, int temperature, int humidity) {
        if (!checkContentsInCache(cityName)) {
            System.out.println("Город " + cityName + " не найден в кэше");
        } else {
            WEATHER_CACHE.computeIfPresent(cityName, (key, oldValue) -> new WeatherData(cityName, temperature, humidity));
        }
    }

    public static void removeWeatherData(String cityName) {
        if (checkContentsInCache(cityName)) {
            WEATHER_CACHE.remove(cityName);
        } else {
            System.out.println("Город " + cityName + " не найден в кэше");
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
        WeatherData weatherInHamburg = new WeatherData("Hamburg", 15, 45);
        WeatherData weatherInPrague = new WeatherData("Prague", 22, 20);
        WeatherData weatherInBarcelona = new WeatherData("Barcelona", 25, 40);

        addData(weatherInHamburg);
        addData(weatherInPrague);
        addData(weatherInBarcelona);

        getAllWeatherData();
        System.out.println();

        System.out.println(getWeatherData("Berlin"));
        System.out.println();

        updateWeatherData("Hamburg", 17, 36);
        System.out.println(getWeatherData("Hamburg"));
        System.out.println();

        removeWeatherData("Hamburg");

        getAllWeatherData();
    }
}