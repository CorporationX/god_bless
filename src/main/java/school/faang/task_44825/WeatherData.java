package school.faang.task_44825;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}
