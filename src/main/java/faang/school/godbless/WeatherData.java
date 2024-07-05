package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class WeatherData {
    private String city;
    private Integer temperature;
    private Integer humidity;
}
