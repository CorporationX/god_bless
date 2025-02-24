package school.faang.task_44820;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
