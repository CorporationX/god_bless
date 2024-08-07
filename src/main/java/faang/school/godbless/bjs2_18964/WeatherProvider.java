package faang.school.godbless.bjs2_18964;

import java.util.Random;

public class WeatherProvider {
    public static WeatherDto receiveWeatherByCity(String city) {
        var random = new Random();

        int minT = -30;
        int maxT = 30;
        int t = random.nextInt((maxT - minT) + 1) + minT;

        int minH = 1;
        int maxH = 99;
        int h = random.nextInt((maxH - minH) + 1) + minH;

        return WeatherDto.builder()
                .city(city)
                .temperature(t)
                .humidity(h)
                .build();
    }
}
