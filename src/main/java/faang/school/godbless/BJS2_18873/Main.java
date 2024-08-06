package faang.school.godbless.BJS2_18873;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
public class Main {
    private final Map<String, WeatherData> weatherMap = new HashMap<>();

    {
        weatherMap.put("London", new WeatherData("London", 15, 55));
        weatherMap.put("Amsterdam", new WeatherData("Amsterdam", 12, 70));
        weatherMap.put("Paris", new WeatherData("Paris", 20, 82));
    }

    WeatherExternalService weatherExternalService = new WeatherExternalService();

    public WeatherData getCurrentWeather(String city) {
        WeatherData request = weatherMap.get(city);
        if (request == null) {
            return weatherMap.put(city, weatherExternalService.getWeather(city));
        } else {
            return request;
        }
    }

    public void updateWeather(String city) {
        if (weatherMap.containsKey(city)) weatherMap.put(city, weatherExternalService.getWeather(city));
    }

    public boolean clearCityCash(String city) {
        return weatherMap.remove(city) != null;
    }

    public Set<String> availableCities() {
        return weatherMap.keySet();
    }


}
