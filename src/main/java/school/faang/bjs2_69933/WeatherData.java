package school.faang.bjs2_69933;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class WeatherData {
    @EqualsAndHashCode.Include
    private final String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
