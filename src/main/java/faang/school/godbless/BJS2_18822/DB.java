package faang.school.godbless.BJS2_18822;

import java.util.HashMap;

public class DB {
    private static HashMap<String, WeatherData> memory = new HashMap<>();

    static {
        memory.put("London", new WeatherData("London", "17°C", "20%"));
        memory.put("New-York", new WeatherData("New-York", "12°C", "29%"));
        memory.put("Paris", new WeatherData("Paris", "15°C", "50%"));
        memory.put("Tokyo", new WeatherData("Tokyo", "20°C", "65%"));
        memory.put("Sydney", new WeatherData("Sydney", "22°C", "30%"));
        memory.put("Moscow", new WeatherData("Moscow", "10°C", "40%"));
        memory.put("Berlin", new WeatherData("Berlin", "18°C", "25%"));
    }

    private DB() {

    }

    public static WeatherData getFromDB(String city) {
        return memory.get(city);
    }
}
