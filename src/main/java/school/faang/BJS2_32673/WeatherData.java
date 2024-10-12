package school.faang.BJS2_32673;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class WeatherData {

    private String city;
    private double temperature;
    private double humidity;

}
