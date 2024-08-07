package faang.school.godbless.bjs2_18964;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {
    private String city;
    private int temperature;
    private int humidity;
}
