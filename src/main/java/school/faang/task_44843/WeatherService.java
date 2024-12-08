package school.faang.task_44843;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city);
    }
}
