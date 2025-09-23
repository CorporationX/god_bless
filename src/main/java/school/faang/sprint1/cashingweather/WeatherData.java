package school.faang.sprint1.cashingweather;

/**
 * Reprsents weather info for a specific city
 */

public record WeatherData(
    String city,
    double temperature,
    double humidity,
    long timestamp) {
}
