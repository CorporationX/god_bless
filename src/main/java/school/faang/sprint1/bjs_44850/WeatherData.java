package school.faang.sprint1.bjs_44850;

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
