package school.faang.bjs244816;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}
