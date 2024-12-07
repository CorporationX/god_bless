package school.faang.caching_caching;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Getter
public record WeatherData(String city, double temperature, double humidity, long timestamp) {
}
