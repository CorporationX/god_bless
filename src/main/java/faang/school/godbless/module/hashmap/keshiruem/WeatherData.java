package faang.school.godbless.module.hashmap.keshiruem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
