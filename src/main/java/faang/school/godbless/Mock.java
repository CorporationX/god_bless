package faang.school.godbless;

import java.util.concurrent.ThreadLocalRandom;

public class Mock {
    private final ThreadLocalRandom rand = ThreadLocalRandom.current();
    public WeatherData createWeather(String city)
    {
        return new WeatherData(city, rand.nextDouble(40.0), rand.nextInt(100));
    }
}
