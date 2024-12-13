package school.faang.bjs44852;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
