package school.faang.s13task44826;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class WeatherData {
    private final City city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}