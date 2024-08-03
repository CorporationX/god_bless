package faang.school.godbless.BJS2_18873;

public class WeatherExternalService {

    public WeatherData getWeather(String city) {
        return new WeatherData(city, 10, 5);
    }
}
