package faang.school.godbless.BJS2_18873;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
public class Main {
    private final Map<String, WeatherData> data = new HashMap<>();

    {
        data.put("London", new WeatherData("London", 15, 55));
        data.put("Amsterdam", new WeatherData("Amsterdam", 12, 70));
        data.put("Paris", new WeatherData("Paris", 20, 82));
    }

    WeatherExternalService weatherExternalService = new WeatherExternalService();

    public WeatherData getCurrentWeather(String city) {
        WeatherData request = data.get(city);
        if (request == null) {
            return data.put(city, weatherExternalService.getWeather(city));
        } else {
            return request;
        }
    }

    public void updateWeather(String city) {
        if (data.containsKey(city)) data.put(city, weatherExternalService.getWeather(city));
    }

    public boolean clearCityCash(String city) {
        return data.remove(city) != null;
    }

    public Set<String> availableCities() {
        return data.keySet();
    }


}
