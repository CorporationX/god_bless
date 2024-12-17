package school.faang.wecachwecachbjs44833;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@ToString
@EqualsAndHashCode
@Getter
@AllArgsConstructor

public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;
}
