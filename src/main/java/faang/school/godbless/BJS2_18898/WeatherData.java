package faang.school.godbless.BJS2_18898;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class WeatherData {
    private String city;
    @Setter
    private double temperature;
    @Setter
    private double humidity;
}
