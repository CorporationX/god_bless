package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Stub {
    static Map<String, WeatherData> x = new HashMap<>();

    static {
        x.put("London", new WeatherData("London", 12, 1));
        x.put("Moscow", new WeatherData("Moscow", 20, 2));
        x.put("St.Petersburg", new WeatherData("St.Petersburg", 24, 3));
        x.put("USA", new WeatherData("USA", 18, 4));
        x.put("Texas", new WeatherData("Texas", 17, 5));
        x.put("Mexico", new WeatherData("Mexico", 32, 6));
    }


    public static WeatherData getInfoWeatherData(String city) {
        return x.get(city);
    }

}
