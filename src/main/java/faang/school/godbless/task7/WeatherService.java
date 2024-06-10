package faang.school.godbless.task7;

import java.util.Random;

public class WeatherService { // внешний сервис
    public static WeatherData getWeatherByCityName(String city) {
        Random r = new Random();
        return new WeatherData(city, r.nextFloat() * 100, r.nextFloat() * 100);
    }
}
