package faang.school.godbless.alexbulgakoff.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexander Bulgakov
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherData {

    private String city;

    private double temperature;

    private int humidity;
}
