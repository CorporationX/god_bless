package school.faang.BJS232615;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> CITY_TEMPERATURE = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(CITY_TEMPERATURE);
        System.out.println(main.getTemperatureAndCity("London"));
        System.out.println();
        main.updateWeatherInfo("London", new WeatherData("London", 15, 20));
        System.out.println(CITY_TEMPERATURE);
        main.removeCityByName("London");
        System.out.println(CITY_TEMPERATURE);
        System.out.println();
        main.updateWeatherInfo("New York", new WeatherData("New York", 20, 9));
        printAllCitiesAndWeather();

    }

    private void validateCity(String nameOfCity) {
        if (nameOfCity.isEmpty() || nameOfCity.isBlank()) {
            throw new IllegalArgumentException("Please provide a valid city name");
        }
    }

    public WeatherData getTemperatureAndCity(String nameOfCity) {
        validateCity(nameOfCity);

        if (CITY_TEMPERATURE.containsKey(nameOfCity)) {
            return CITY_TEMPERATURE.get(nameOfCity);
        } else {
            WeatherData weatherData = WeatherService.getWeatherData(nameOfCity);
            CITY_TEMPERATURE.put(nameOfCity, weatherData);
            return weatherData;
        }
    }

    public void updateWeatherInfo(String nameOfCity, WeatherData updatedWeatherData) {
        validateCity(nameOfCity);
        CITY_TEMPERATURE.put(nameOfCity, updatedWeatherData);
    }

    public void removeCityByName(String nameOfCity) {
        validateCity(nameOfCity);
        CITY_TEMPERATURE.remove(nameOfCity);
    }

    public static void printAllCitiesAndWeather() {
        CITY_TEMPERATURE.forEach((city, weather) -> System.out.println(city + ":" + weather));
    }
}
