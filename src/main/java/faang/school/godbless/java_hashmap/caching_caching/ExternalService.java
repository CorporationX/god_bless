package faang.school.godbless.java_hashmap.caching_caching;

import java.util.HashMap;
import java.util.Map;

public class ExternalService {


    private static Map<String, WeatherData> externalSource  = new HashMap<>();


    static {
        externalSource.put("London", new WeatherData("London", 15, 80));
        externalSource.put("Paris", new WeatherData("Paris", 32, 40));
        externalSource.put("Berlin", new WeatherData("Berlin", 32, 40));
        externalSource.put("Pekin", new WeatherData("Pekin", 32, 40));
        externalSource.put("Almaty", new WeatherData("Almaty", 10, 40));
        externalSource.put("Moscow", new WeatherData("Moscow", 20, 70));
        externalSource.put("Tashkent", new WeatherData("Tashkent", 1, 40));
        externalSource.put("Taraz", new WeatherData("Taraz", 6, 54));
    }


    public static WeatherData getExternalWD(String city) {
        WeatherData weatherData = null;
        for (Map.Entry<String, WeatherData> entry : externalSource.entrySet()) {
            if (entry.getKey().equals(city)) {
                weatherData = entry.getValue();
                break;
            }
        }
        return weatherData;
    }





}
