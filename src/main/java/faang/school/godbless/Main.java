package faang.school.godbless;

import ch.qos.logback.classic.util.LogbackMDCAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static Map<String, WeatherData> weatherInTheCity = new HashMap<>();
    private final static Mock mockServise = new Mock();

    public static void weatherMain() throws IOException {
        WeatherData newYork = new WeatherData("New York", 25.1, 30);
        WeatherData miami = new WeatherData("Miami", 30, 70);

        weatherInTheCity.put(newYork.getCity(), newYork);
        weatherInTheCity.put(miami.getCity(), miami);
        getWeatherInTheCity("Dubai");
        updateWeather("Dubai");
        remove("Dubai");
        printAllCitys();

    }

    private static WeatherData getWeatherInTheCity(String city) {
        if (weatherInTheCity.containsKey(city)) {
            return weatherInTheCity.get(city);
        }
        WeatherData createWD = mockServise.createWeather(city);
        weatherInTheCity.put(city, createWD);
        return createWD;
    }

    private static void updateWeather(String city) throws IOException {
        if (!(weatherInTheCity.containsKey(city))) {throw new IOException("The city you sent is not in the database");}
        weatherInTheCity.put(city, mockServise.createWeather(city));
    }

    private static void remove(String city) {
        weatherInTheCity.remove(city);
    }

    private static void printAllCitys() {

        System.out.print("Weather information is available in cities:");
        weatherInTheCity.forEach((city, weather) -> {
            System.out.print(" " + city);
        });
    }
}
