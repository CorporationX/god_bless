package faang.school.godbless.BJS2_18893;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, WeatherData> weatherCity = new HashMap<>();
        weatherCity.put("Piter", new WeatherData("Piter", 10, 60));
        weatherCity.put("Moscow", new WeatherData("Moscow", 15, 34));
        weatherCity.put("London", new WeatherData("London", 25, 12));

        WeatherData weatherDataInPiter = WeatherData.getWeatherData(weatherCity, "Piter");
        System.out.println(weatherDataInPiter);

        WeatherData weatherDataInKazan = WeatherData.getWeatherData(weatherCity, "Kazan");
        System.out.println(weatherDataInKazan);
        System.out.println(weatherCity);
    }
}
