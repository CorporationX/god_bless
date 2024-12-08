package school.faang.task_44825;

import java.util.HashMap;
import java.util.Map;

public class DataInitializerUtils {
    public static Map<String, WeatherData> initData() {
        return new HashMap<>() {{
                put("Moscow", new WeatherData("Moscow", 25, 40, System.currentTimeMillis()));
                put("Saint-Petersburg", new WeatherData("Saint-Petersburg", 15, 70, System.currentTimeMillis()));
                put("Kazan", new WeatherData("Kazan", 35, 20, System.currentTimeMillis()));
            }};
    }
}