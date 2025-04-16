package school.faang.sprint_1.caching_caching;

public record WeatherData(
        String city,
        Double temperature,
        Double humidity,
        long timestamp
) {
}