package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class WeatherData {

    private String city;
    private Double temperature;
    private Double humidity;

    public void setTempAndHumi(Double temperature, Double humidity){
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
