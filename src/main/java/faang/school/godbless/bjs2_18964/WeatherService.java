package faang.school.godbless.bjs2_18964;

import java.util.HashMap;
import java.util.Map;

/**
 * Without synchronization for educational purposes
 */
public class WeatherService {
    private final Map<String, WeatherData> data;

    private static WeatherService instance;

    private WeatherService() {
        data = new HashMap<>();
    }

    public static WeatherService getInstance() {
        if (instance == null) {
            instance = new WeatherService();
        }
        return instance;
    }

    public WeatherData getWeatherDataByCity(String city) {
        var weatherData = data.get(city);
        if (weatherData != null) {
            return weatherData;
        }

        return updateWeatherForCity(city);
    }

    public WeatherData updateWeatherForCity(String city) {
        var weatherDto = WeatherProvider.receiveWeatherByCity(city);
        var weatherData = toWeatherData(weatherDto);
        data.put(city, weatherData);
        return weatherData;
    }

    public void removeWeatherForCity(String city) {
        data.remove(city);
    }

    public void printWeather() {
        for (Map.Entry<String, WeatherData> entry : data.entrySet()) {
            System.out.println("City: " + entry.getKey());
            entry.getValue().printData();
        }
    }

    private WeatherData toWeatherData(WeatherDto weatherDto) {
        return WeatherData.builder()
                .city(weatherDto.getCity())
                .temperature(weatherDto.getTemperature())
                .humidity(weatherDto.getHumidity())
                .build();
    }
}
