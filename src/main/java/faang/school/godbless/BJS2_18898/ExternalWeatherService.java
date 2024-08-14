package faang.school.godbless.BJS2_18898;

import java.util.Random;

public class ExternalWeatherService {

    public static WeatherData getWeatherData(String city) {
        Random rand = new Random();
        double temp = (double) Math.round((rand.nextDouble(20, 35) * 100)) /100;
        double humidity = (double) Math.round((rand.nextDouble(70, 99) * 100)) /100;

        return new WeatherData(city, temp, humidity);
    }
}
