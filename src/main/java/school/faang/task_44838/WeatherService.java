package school.faang.task_44838;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -10 + Math.random() * 40;
        double humidity = Math.random() * 100;
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
