package faang.school.godbless.WeatherData;



import static java.lang.Math.random;

public class WeatherService {
    public WeatherData getWeatherData(String city) {

        return new WeatherData(city, (float) (random() * 40 - 10), (float) (random() * 100));
    }
}