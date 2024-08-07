package faang.school.godbless.BJS2_18898;

import java.util.Random;

public class ExternalWeatherService {

    public static WeatherData getWeatherData(String city) {
        Random rand = new Random();

        String temp = String.format("%.2f", rand.nextDouble(20, 35))
                .replace(",", ".");
        String humidity = String.format("%.2f", rand.nextDouble(70, 99))
                .replace(",", ".");

        return new WeatherData(city, Double.parseDouble(temp), Double.parseDouble(humidity));
    }
}
