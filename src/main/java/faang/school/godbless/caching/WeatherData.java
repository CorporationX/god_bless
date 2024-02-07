package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class WeatherData {

    private String city;
    private int temperature;
    private int humidity;
}
