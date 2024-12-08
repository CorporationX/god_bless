package faang.school.godbless.sprint_1.task_19053;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WeatherData {
    @Getter
    private final City city;
    private final double temperature;
    private final double humidity;
}
