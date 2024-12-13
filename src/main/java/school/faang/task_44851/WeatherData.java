package school.faang.task_44851;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}