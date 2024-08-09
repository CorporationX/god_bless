package faang.school.godbless.cash;

import java.util.Random;

public class WeatherService {
    private static final Random rnd = new Random();

    public static WeatherData getForecast(String city) {
        int temp = rnd.nextInt(-20, 31);
        int humility = rnd.nextInt(20, 60);
        return new WeatherData(city, temp, humility);
    }
}
