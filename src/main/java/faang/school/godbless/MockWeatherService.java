package faang.school.godbless;


import java.util.Random;

public class MockWeatherService {
    public WeatherData getWeather(String city) {
        return new WeatherData(city, new Random(40).nextInt(), new Random(100).nextInt());
    }
}
