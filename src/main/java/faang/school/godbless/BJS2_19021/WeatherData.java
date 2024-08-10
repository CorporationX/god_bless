package faang.school.godbless.BJS2_19021;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    public WeatherData getDataFromCache(String city, Map<String, WeatherData> cache) {
        if (cache.containsKey(city))
            return cache.get(city);
        else
            return requestWeatherData(city, cache).get(city);
    }

    public void updateWeatherData(String city, Map<String, WeatherData> cache, double temperature, double humidity) {
        WeatherData weatherDataOfCity;

        if (cache.containsKey(city)) {
            weatherDataOfCity = cache.get(city);
            weatherDataOfCity.setTemperature(temperature);
            weatherDataOfCity.setHumidity(humidity);
        } else
            System.out.println("City " + city + " not found");
    }

    public void removeWeatherData(String city, Map<String, WeatherData> cache) {
        cache.remove(city);
    }

    public void printAllowedCitiesFromCache(Map<String, WeatherData> cache) {
        cache.forEach((k, v) -> System.out.println(v.city));
    }

    private Map<String, WeatherData> requestWeatherData(String city, Map<String, WeatherData> cache) {
        System.out.println("Data in cache doesn't exists! Requesting weather data...");
        var weatherData = new WeatherData(city, 32, 50);
        cache.put(city, weatherData);
        return cache;
    }
}
