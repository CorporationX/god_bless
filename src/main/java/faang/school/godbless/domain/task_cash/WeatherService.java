package faang.school.godbless.domain.task_cash;

import java.util.Random;

public class WeatherService {
    public WeatherData getService(String city) {
        Random r = new Random();
        return new WeatherData(city, new Random().nextDouble(), new Random().nextDouble());
    }
}
