package faang.school.godbless.BJS2_18898;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherCities = new HashMap<>();

    public static void main(String[] args) {
        WeatherData kazan = new WeatherData("Kazan", 25.5, 72.3);
        WeatherData moscow = new WeatherData("Moscow", 23.7, 75.8);
        WeatherData samara = new WeatherData("Samara", 27.3, 81.8);
        WeatherData nignekamsk = new WeatherData("Nignekamsk", 25.1, 73.3);
        WeatherData novgorod = new WeatherData("Novgorod", 24.9, 83.5);

        weatherCities.put(kazan.getCity(), kazan);
        weatherCities.put(moscow.getCity(), moscow);
        weatherCities.put(samara.getCity(), samara);
        weatherCities.put(nignekamsk.getCity(), nignekamsk);
        weatherCities.put(novgorod.getCity(), novgorod);

        printWeatherByCity("Moscow");
        printWeatherAllCitites();
        System.out.println("-------------");
        printWeatherByCity("Orel");
        updateWeatherCity("Samara", -10, 50);
        removeWeatherCity("Nignekamsk");
        System.out.println("-------------");
        printWeatherAllCitites();
    }

    public static void printWeatherByCity(String city) {
        WeatherData weatherData = getWeatherData(city);
        System.out.println("Current weather in " + city + ": temp - "
                + weatherData.getTemperature()
                + " humidity - " + weatherData.getHumidity());
    }

    public static WeatherData getWeatherData(String city) {
        if (weatherCities.containsKey(city)) {
            return weatherCities.get(city);
        } else {
            weatherCities.put(city, ExternalWeatherService.getWeatherData(city));
            return weatherCities.get(city);
        }
    }

    public static void printWeatherAllCitites() {
        for (var entry : weatherCities.entrySet()) {
            double temperature = entry.getValue().getTemperature();
            double humidity = entry.getValue().getHumidity();
            System.out.println(entry.getKey() + " : temperature - " + temperature + " humidity - " + humidity);
        }
    }

    public static void updateWeatherCity(String city, double temperature, double humidity) {
        weatherCities.put(city, new WeatherData(city, temperature, humidity));
    }

    public static void removeWeatherCity(String city) {
        weatherCities.put(city, new WeatherData(city, 0.0, 0.0));
    }
}
