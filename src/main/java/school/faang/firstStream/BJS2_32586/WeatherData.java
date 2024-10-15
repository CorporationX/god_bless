package school.faang.firstStream.BJS2_32586;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class WeatherData {
    private City city;
    private int temperature;
    private int humidity;
}
