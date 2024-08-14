package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class WeatherData {
    private String city;
    private Float temperature;
    private Float humidity;
}
