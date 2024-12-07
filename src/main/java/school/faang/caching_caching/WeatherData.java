package school.faang.caching_caching;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public record WeatherData(String city, double temperature, double humidity, long timestamp) {
}
