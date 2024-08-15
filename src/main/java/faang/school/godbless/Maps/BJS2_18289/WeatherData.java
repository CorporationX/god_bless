package faang.school.godbless.Maps.BJS2_18289;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public String getCity() {
        return city;
    }
}
