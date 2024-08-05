package faang.school.godbless.cachingcaching;

import java.util.HashMap;
import java.util.Map;

public class DB {

    public static final Map<String, WeatherData> MEMORY = new HashMap<>();

    static {
        MEMORY.put("Saint Petersburg", new WeatherData("Saint Petersburg", 23.7, 50));
        MEMORY.put("Moscow", new WeatherData("Moscow", 28.3, 60));
        MEMORY.put("Voronezh", new WeatherData("Voronezh", 26.1, 70));
        MEMORY.put("Kazan", new WeatherData("Kazan", 24.6, 40));
        MEMORY.put("Kaliningrad", new WeatherData("Kaliningrad", 22.8, 30));
        MEMORY.put("Yekaterinburg", new WeatherData("Yekaterinburg", 29.3, 30));
    }

    private DB() {

    }

    public static WeatherData getByCity(String city) {
        return MEMORY.get(city);
    }
}