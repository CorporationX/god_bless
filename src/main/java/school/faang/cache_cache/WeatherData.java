package school.faang.cache_cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class WeatherData {
    private final String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
