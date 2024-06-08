package faang.school.godbless.BJS2_8914;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class WeatherData {
    @ToString.Include(name = "Город")
    private String city;
    @ToString.Include(name = "Температура")
    private double temperature;
    @ToString.Include(name = "Влажность")
    private int humidity;
}
