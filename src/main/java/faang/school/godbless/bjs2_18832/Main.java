package faang.school.godbless.bjs2_18832;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> cityInfo = new HashMap<>();
        cityInfo.put("Moscow", new WeatherData("Moscow", 20, 40));
        cityInfo.put("Piter", new WeatherData("Piter", 15, 50));

        System.out.println(WeatherData.getWeatherData(cityInfo, "Kazan"));
        WeatherData.informationUpdate("Moscow", cityInfo, new WeatherData("Moscow", 30, 50));
        System.out.println(cityInfo);
        WeatherData.informationDelete("Kazan", cityInfo);
        System.out.println(cityInfo);
        WeatherData.informationOutput(cityInfo);

    }
}
