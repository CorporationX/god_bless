package school.faang.task_46151.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class WeatherData {
    private final City city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}