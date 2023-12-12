package faang.school.godbless.Caching;

import java.util.Random;

public class ServerData {
    public static WeatherData getWeather(String city) {
        return new WeatherData(city, new Random().nextInt(10), new Random().nextInt(20, 100));
    }

}
