package faang.school.godbless.BJS28688;

import java.util.HashMap;
import java.util.Map;

public class CityWeatherMap {
    private Map<String, WeatherData> cityWeatherMap;


    public CityWeatherMap() {
        cityWeatherMap = new HashMap<String, WeatherData>();
    }

    public WeatherData getWeather(String city) {
        if (!cityWeatherMap.containsKey(city)) {
            cityWeatherMap.put(city, MockWeatherData.getWeather(city));
        }
        return cityWeatherMap.get(city);
    }

    public void updateWeather(WeatherData cityWeather) {
        if (cityWeatherMap.containsKey(cityWeather.getCity())) {
            cityWeatherMap.put(cityWeather.getCity(), cityWeather);
            System.out.println("Weather information in the city " + cityWeather.getCity() + " updated successfully\n");
        } else {
            System.out.println(cityWeather.getCity() + " doesn't exist in the map. Use addWeather\n");
        }
    }

    public void removeWeather(String city) {
        if (cityWeatherMap.containsKey(city)) {
            cityWeatherMap.remove(city);
            System.out.println("Weather information in the city " + city + " removed successfully\n");
        } else {
            System.out.println(city + " doesn't exist in the map.\n");
        }

    }

    public void printAllInfo() {
        System.out.println("Start printing weather information for all cities");
        System.out.println("================================================");
        cityWeatherMap.forEach((key, value) -> System.out.println(value));
        System.out.println("================================================");
        System.out.println("Finish printing weather information for all cities\n");
    }

    public void addWeather(WeatherData cityWeather) {
        if (cityWeatherMap.containsKey(cityWeather.getCity())) {
            System.out.println("This city has already exist in the map. Use updateWeather!\n");
        } else {
            cityWeatherMap.put(cityWeather.getCity(), cityWeather);
            System.out.println("Weather information in the city " + cityWeather.getCity() + " added successfully\n");
        }
    }


}
