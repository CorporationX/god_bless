package faang.school.godbless.caching;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Weather {
    private String city;
    private int temperature;
    private int humidity;
}
