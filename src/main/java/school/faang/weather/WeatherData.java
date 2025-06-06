package school.faang.weather;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
public record WeatherData(String city, double temperature, double humidity, long timestamp) {

    public static final WeatherData EMPTY = new WeatherData("", 0, 0, 0);
}
