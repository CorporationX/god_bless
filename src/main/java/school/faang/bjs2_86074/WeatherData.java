package school.faang.bjs2_86074;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double  temperature;
    private double humidity;
    private long timeStamp;
}
