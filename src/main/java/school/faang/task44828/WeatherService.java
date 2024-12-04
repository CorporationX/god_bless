package school.faang.task44828;

public class WeatherService implements WeatherProvider {
    private static final int MIN_TEMP = -40;
    private static final int MAX_TEMP = 40;

    @Override
    public WeatherData fetchWeatherData(String city) {
        if (city.isBlank()) {
            throw new IllegalArgumentException("City is blank");
        }

        return new WeatherData(city, Math.random() * (MAX_TEMP - MIN_TEMP) + MIN_TEMP,
                Math.random() * 100,
                System.currentTimeMillis());
    }
}
