package school.faang.task44828;

public class WeatherService implements WeatherProvider {
    private final static int MIN_TEMP = -40;
    private final static int MAX_TEMP = 40;

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
