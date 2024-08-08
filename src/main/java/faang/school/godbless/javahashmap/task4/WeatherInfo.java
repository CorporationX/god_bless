package faang.school.godbless.javahashmap.task4;

import java.util.Random;

public class WeatherInfo {
    public WeatherData getWeatherInfo(String city) {
        Random random = new Random();
        return new WeatherData(city, random.nextInt(30) + 1, random.nextInt(20) + 50);
    }
}
