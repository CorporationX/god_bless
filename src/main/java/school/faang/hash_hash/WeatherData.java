package school.faang.hash_hash;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class WeatherData {

    private String city;
    private double temperature;
    private double humidity;
    private long timestamp = System.currentTimeMillis();

}
