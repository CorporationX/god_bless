package school.faang.cashing;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
