package school.faang.task56921.weather;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
