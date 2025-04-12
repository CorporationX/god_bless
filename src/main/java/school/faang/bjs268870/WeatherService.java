package school.faang.bjs268870;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, Math.random() * 100, Math.random() * 100, System.currentTimeMillis());
    }
}
