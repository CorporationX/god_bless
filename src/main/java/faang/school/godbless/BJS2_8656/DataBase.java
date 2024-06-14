package faang.school.godbless.BJS2_8656;

import java.util.Random;

public class DataBase {
    public WeatherData getWeatherData(String city) {
        return new WeatherData(city,
                new Random().nextInt(10, 45),
                new Random().nextInt(0, 100));
    }
}
