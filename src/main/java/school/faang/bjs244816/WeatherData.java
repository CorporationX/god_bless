package school.faang.bjs244816;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private  final long timestamp;
}
