package faang.school.godbless.javahashmap.task4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class WeatherData {
    private String city;
    private Integer temperature;
    private Integer humidity;
}
