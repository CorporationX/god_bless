package school.faang.collections.double_cache.provider;

public record WeatherData(
        String city,
        Double temperature,
        Double humidity,
        long timestamp
) {
}