package faang.school.godbless.sprint_1.caching_caching;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class WeatherService {

    public WeatherData getWeatherData(String city) {
       return new WeatherData(
               city,
               new Random().nextInt(-10, 30),
               new Random().nextInt(10, 80)
       );
    }

}
