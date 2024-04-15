package faang.school.godbless.BJS2_4281;

import java.util.Random;

public class WeatherDataService {

    public WeatherData weatherData(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(-20, 31), random.nextInt(30, 96));
    }
}
