package school.faang.bjs268870;

public class WeatherService implements WeatherProvider {

    private static final int HUNDRED = 100;

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, Math.random() * HUNDRED, Math.random() * HUNDRED, System.currentTimeMillis());
    }
}
