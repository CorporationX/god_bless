package school.faang.m1s1.bsj2_32566_Cache;

public class WeatherService {
    private final String city;
    private double temperature;
    private double humidity;

    public WeatherService(String city) {
        this.city = city;
        this.temperature = Math.round(Math.random() * 40);
        this.humidity = 50 + Math.round(Math.random() * 40);
    }
    public WeatherData provideData() {
        return new WeatherData(city, temperature, humidity);
    }
}
