package school.faang.weather;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public interface WeatherProvider {
    WeatherData fetchWeatherData(String city);
}
