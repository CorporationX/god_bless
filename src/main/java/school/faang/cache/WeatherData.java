package school.faang.cache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}