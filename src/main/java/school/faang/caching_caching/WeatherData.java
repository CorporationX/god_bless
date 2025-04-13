package school.faang.caching_caching;

public record WeatherData(
        String city,
        Double temperature,
        Double humidity,
        long timestamp
) {
}