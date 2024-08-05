package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
