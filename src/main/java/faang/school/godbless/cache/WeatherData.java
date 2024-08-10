package faang.school.godbless.cache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private int humidity;
}
