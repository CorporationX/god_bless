package faang.school.godbless.javahashmap.cache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
