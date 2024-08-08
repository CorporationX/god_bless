package CashCash;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Main {
    public static void main(String[] args) {
        Map<String, WheatherDate> weatherMap = new HashMap<String, WheatherDate>();
        weatherMap.put("Moscow", new WheatherDate("Moscow", "15", "80%"));

        WheatherDate.updateWheather("Kazan", "18", "56%", weatherMap);

        WheatherDate.searchWeather("Kazan", weatherMap);
        WheatherDate.searchWeather("Boston", weatherMap);

        System.out.println();
        WheatherDate.outputWheather(weatherMap);

        WheatherDate.removeWheather("Kazan", weatherMap);

        System.out.println();
        WheatherDate.outputWheather(weatherMap);
    }
}
