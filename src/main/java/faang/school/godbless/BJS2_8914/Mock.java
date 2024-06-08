package faang.school.godbless.BJS2_8914;

import java.util.HashMap;
import java.util.Map;


public class Mock {
    Map<String, WeatherData> weatherDataList = new HashMap<>();

    public Mock() {
        weatherDataList.put("London", new WeatherData("London", 34.4, 50));
        weatherDataList.put("Paris", new WeatherData("Paris", 54.4, 77));
        weatherDataList.put("Rome", new WeatherData("Rome", 31.3, 30));
        weatherDataList.put("New York", new WeatherData("New York", 23.5, 30));
        weatherDataList.put("Moscow", new WeatherData("Moscow", 15.4, 20));
    }

    public WeatherData getWeatherInCity(String city) {
        if (!weatherDataList.containsKey(city)) throw new IllegalArgumentException("Такой город не найден в списке");
        return weatherDataList.get(city);
    }
}
