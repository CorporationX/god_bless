package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@ToString
public class WeatherData {
    private String cityName;
    private double temperature;
    private double humidity;
}
