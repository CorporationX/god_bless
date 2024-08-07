package faang.school.godbless.BJS2_18900;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
}
