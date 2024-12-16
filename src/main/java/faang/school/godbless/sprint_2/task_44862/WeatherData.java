package faang.school.godbless.sprint_2.task_44862;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WeatherData {
    @Getter
    private String city;
    private double temperature;
    private double humidity;
    @Getter
    private long timestamp;
}
