package school.faang.task_44821;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherData {
    private final City city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}
