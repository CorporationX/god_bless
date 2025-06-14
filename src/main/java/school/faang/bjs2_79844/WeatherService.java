package school.faang.bjs2_79844;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -20 + Math.random() * (40 - (-20));
        double humidity = Math.random() * 100;
        long currentTime = System.currentTimeMillis();
        return new WeatherData(city, temperature, humidity, currentTime);
    }
}
