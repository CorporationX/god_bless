package school.faang.task44870.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double  humidity;
    private final long timestamp;
}
