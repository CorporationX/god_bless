package faang.school.godbless.cache.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;
}
