package school.faang.sprint_1.task_44835.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
