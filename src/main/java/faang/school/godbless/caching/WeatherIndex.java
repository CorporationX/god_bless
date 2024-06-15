package faang.school.godbless.caching;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public class WeatherIndex {
    private Map<String, Weather> weatherIndex;

    public WeatherIndex() {
        this.weatherIndex = new HashMap<>();
    }

    public Weather getWeather(String cityName) {
        if (weatherIndex.containsKey(cityName)) {
            return weatherIndex.get(cityName);
        } else {
            log.info("Getting Weather from our resources");
            Weather newWeather = getWeatherInformation(cityName);
            weatherIndex.put(cityName, newWeather);
            return newWeather;
        }
    }

    public void updateCityWeather(String cityName) {
        weatherIndex.put(cityName, getWeatherInformation(cityName));
    }

    public void deleteCityWeather(String cityName) {
        if (weatherIndex.containsKey(cityName)) {
            weatherIndex.remove(cityName);
        } else {
            log.warn("Could not find and remove weather with name {}", cityName);
        }
    }

    public void showAllWeatherDate() {
        for (Map.Entry<String, Weather> weather : weatherIndex.entrySet()) {
            System.out.println("Weather in " + weather.getKey() + " is " + weather.getValue());
        }
    }

    public Weather getWeatherInformation(String cityName) {
        // Возвращает диапазон от -50 до 50
        int temperature = (int) (Math.random() * 101) - 50;
        int humidity = (int) (Math.random() * 50);

        return new Weather(cityName, temperature, humidity);
    }
}
