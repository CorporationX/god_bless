package school.faang.BJS232615;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CITY_TEMPERATURE = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(CITY_TEMPERATURE);
        System.out.println(getTemperatureAndCity("London"));
        System.out.println();
        updateWeatherInfo("London", new WeatherData("London", 15, 20));
        System.out.println(CITY_TEMPERATURE);
        removeCityByName("London");
        System.out.println(CITY_TEMPERATURE);
        System.out.println();
        updateWeatherInfo("New York", new WeatherData("New York", 20, 9));
        printAllCitiesAndWeather();

    }

    public static WeatherData getTemperatureAndCity(String nameOfCity) {
        if (nameOfCity.isEmpty() || nameOfCity.isBlank()) {
            throw new IllegalArgumentException("Fill the nameOfCity" + nameOfCity);
        }

        if (CITY_TEMPERATURE.containsKey(nameOfCity)) {
            return CITY_TEMPERATURE.get(nameOfCity);
        } else {
            WeatherData weatherData = MockClass.getWeatherData(nameOfCity);
            CITY_TEMPERATURE.put(nameOfCity, weatherData);
            return weatherData;
        }
    }

    public static void updateWeatherInfo(String nameOfCity, WeatherData updatedWeatherData) {
        if (nameOfCity.isEmpty() || nameOfCity.isBlank()) {
            throw new IllegalArgumentException("Please provide a valid city name");
        }

        CITY_TEMPERATURE.put(nameOfCity, updatedWeatherData);
    }

    public static void removeCityByName(String nameOfCity) {
        if (nameOfCity.isEmpty() || nameOfCity.isBlank()) {
            throw new IllegalArgumentException("Fill the nameOfCity" + nameOfCity);
        }
        CITY_TEMPERATURE.remove(nameOfCity);
    }

    public static void printAllCitiesAndWeather() {
        CITY_TEMPERATURE.forEach((city, weather) -> System.out.println(city + ":" + weather));
    }
}
