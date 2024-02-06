package faang.school.godbless.cache;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

}
