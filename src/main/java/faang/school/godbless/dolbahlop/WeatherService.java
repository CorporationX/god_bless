package faang.school.godbless.dolbahlop;

public class WeatherService {
    public WeatherData getWeatherData(String city) {
        return new WeatherData(city, Math.random() * 40, Math.random() * 100);
    }
}
