package school.faang.BJS2_86058;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    @Getter
    private final long timestamp;
}
