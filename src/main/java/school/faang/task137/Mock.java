package school.faang.task137;

import java.util.Random;

public class Mock {

    public static WeatherData getWeather(String cityName) {
        Random random = new Random();
        int temperature = random.nextInt(38);
        double humidity = random.nextDouble(95.00);
        return new WeatherData(cityName, temperature, humidity);
    }

}
