package school.faang.BSJ2_87000;

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
    private double temperature;
    private double humidity;
    private long timestamp;

}
