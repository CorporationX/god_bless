package faang.school.godbless.cache_cache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
