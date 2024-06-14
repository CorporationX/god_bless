package faang.school.godbless.cache_cache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, WeatherData> weatherInCities = new HashMap<>();

    public static void main(String[] args) {
        WeatherData weatherData1 = new WeatherData("London", 18, 92);
        WeatherData weatherData2 = new WeatherData("Sidney", 29, 75);
        WeatherData weatherData3 = new WeatherData("Minsk", 23, 62);

        weatherInCities.put(weatherData1.getCity(), weatherData1);
        weatherInCities.put(weatherData2.getCity(), weatherData2);
        weatherInCities.put(weatherData3.getCity(), weatherData3);

        printAllWeatherData();
        WeatherData weatherDataOfSidney = weatherInSingleCity("Sidney");
        System.out.println(weatherDataOfSidney.getCity() + " : " + weatherDataOfSidney.getTemperature() + ", "
                + weatherDataOfSidney.getHumidity());
        weatherInSingleCity("Berlin");
        printAllWeatherData();
        updateWeatherForCity(new WeatherData("London", 21, 88));
        printAllWeatherData();
        removeWeatherDataByCityName("Berlin");
        printAllWeatherData();
    }

    public static WeatherData weatherInSingleCity(String cityName) {
        return weatherInCities.computeIfAbsent(cityName, ExternalService::getDataAboutWeather);
    }

    public static void updateWeatherForCity(WeatherData newWeatherData) {
        weatherInCities.replace(newWeatherData.getCity(), newWeatherData);
    }

    public static void removeWeatherDataByCityName(String cityName) {
        weatherInCities.remove(cityName);
    }

    public static void printAllWeatherData() {
        for (var entry : weatherInCities.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(" ");
    }
}
