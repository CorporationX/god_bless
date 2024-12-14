package school.faang.sprint_1.task_44814;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;
}
