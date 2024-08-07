package faang.school.godbless.BJS2_18879;

import java.util.Random;

public class WeatherAPI {
    public static WeatherData getWeather(String city){
        return new WeatherData(city, 32.4, 36);
    }
}
