package school.faang.bjs2_79765;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private Long timestamp;
}
