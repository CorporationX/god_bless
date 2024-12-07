package school.faang.task_44839;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -10 + (int) (Math.random() * 10);
        double humidity = 60 + (int) (Math.random() * 30);
        long timestamp = System.currentTimeMillis();

        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
