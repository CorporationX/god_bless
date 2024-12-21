package derschrank.sprint01.task11.bjstwo_44817;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        Random rnd = new Random();
        return new WeatherData(city,
                (-20 + rnd.nextInt(50)),
                (50 + rnd.nextInt(50)),
                System.currentTimeMillis()
                );
    }
}
