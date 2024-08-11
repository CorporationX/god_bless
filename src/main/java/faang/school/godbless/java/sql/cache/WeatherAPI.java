package faang.school.godbless.java.sql.cache;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class WeatherAPI {
    private final Map<String, WeatherData> weatherDataMap = new HashMap<>();

    public WeatherAPI() {
        this.weatherDataMap.computeIfAbsent("Moscow", k -> new WeatherData()).setAllParams("Moscow", 20, 50);
        this.weatherDataMap.computeIfAbsent("Tallinn", k -> new WeatherData()).setAllParams("Tallinn", 18, 90);
        this.weatherDataMap.computeIfAbsent("Spb", k -> new WeatherData()).setAllParams("Spb", 19, 80);
        this.weatherDataMap.computeIfAbsent("Izhevsk", k -> new WeatherData()).setAllParams("Izhevsk", 25, 30);
    }

    public WeatherData getWeatherData(String city) {
        return this.weatherDataMap.get(city);
    }

}
