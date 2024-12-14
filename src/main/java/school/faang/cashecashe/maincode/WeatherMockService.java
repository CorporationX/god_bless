package school.faang.cashecashe.maincode;

public class WeatherMockService {
    public WeatherData getWeatherData(String city) {
        double temperature = Math.random() * 30;
        double humidity = Math.random() * 100;
        return new WeatherData(city, temperature, humidity);
    }
}
