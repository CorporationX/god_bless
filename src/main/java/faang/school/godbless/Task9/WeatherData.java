package faang.school.godbless.Task9;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class WeatherData {

    private String city;
    private int temperature;
    private int humidity;

}
