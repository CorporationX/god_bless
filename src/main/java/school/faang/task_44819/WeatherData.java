package school.faang.task_44819;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
