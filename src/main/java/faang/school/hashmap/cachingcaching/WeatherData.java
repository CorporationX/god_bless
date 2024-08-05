package faang.school.hashmap.cachingcaching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

}
