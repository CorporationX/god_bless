package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@AllArgsConstructor
@ToString
@Setter
@Accessors(chain = true)
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
