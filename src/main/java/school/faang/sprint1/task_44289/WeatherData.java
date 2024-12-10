package school.faang.sprint1.task_44289;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@Getter
@ToString
public class WeatherData {

    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
