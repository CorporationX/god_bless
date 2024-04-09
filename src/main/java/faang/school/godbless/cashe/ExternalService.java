package faang.school.godbless.cashe;

public class ExternalService {
    public WeatherData getWeather(String city) {
        int temperature = (int) (Math.random() * 55 - 25);
        int humidity = (int) (Math.random() * 51) + 40;
        return new WeatherData(city, temperature, humidity);
    }
}
