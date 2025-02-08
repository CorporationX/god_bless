package school.faang.sprint1.task_BJS2_57007.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
