package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Stub {
    static Map<String, WeatherData> theoreticalBase = new HashMap<>();

    static {
        theoreticalBase.put("London", new WeatherData("London", 12, 1));
        theoreticalBase.put("Moscow", new WeatherData("Moscow", 20, 2));
        theoreticalBase.put("St.Petersburg", new WeatherData("St.Petersburg", 24, 3));
        theoreticalBase.put("USA", new WeatherData("USA", 18, 4));
        theoreticalBase.put("Texas", new WeatherData("Texas", 17, 5));
        theoreticalBase.put("Mexico", new WeatherData("Mexico", 32, 6));
    }


    public static WeatherData getInfoWeatherData(String city) {
        return theoreticalBase.get(city);
    }

}
