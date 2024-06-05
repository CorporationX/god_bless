package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
