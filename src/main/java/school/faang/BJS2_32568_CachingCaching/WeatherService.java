package school.faang.BJS2_32568_CachingCaching;

import java.util.HashMap;
import java.util.Map;

public class WeatherService {
    Map<String, WeatherData> cityToWeather;
    private final WeatherRemoteService remoteService;

    public WeatherService() {
        cityToWeather = new HashMap<>();
        remoteService = new WeatherRemoteService();
    }

    public WeatherData getCityWeather(String city) {
        validateCityName(city);
        WeatherData cityWeather = cityToWeather.get(city);
        if (cityWeather == null) {
            cityWeather = remoteService.getCityWeather(city);
            cityToWeather.put(city, cityWeather);
        }
        return cityWeather;
    }

    public void updateCityWeather(WeatherData cityWeather) {
        if (cityWeather == null)
            throw new IllegalArgumentException("Weather data can't be null.");
        cityToWeather.put(cityWeather.getCity(), cityWeather);
    }

    public void removeCityWeather(String city) {
        validateCityName(city);
        cityToWeather.remove(city);
    }

    public void printAllCitiesWeathers() {
        if (cityToWeather.isEmpty()) {
            System.out.println("No information about any city.");
        } else for (var cityWeather: cityToWeather.values())
            System.out.println(cityWeather);
    }

    private void validateCityName(String city) {
        if (city == null || city.isBlank())
            throw new IllegalArgumentException("Invalid city name.");
    }
}
