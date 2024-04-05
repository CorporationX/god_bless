package faang.school.godbless.CachingCaching;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
