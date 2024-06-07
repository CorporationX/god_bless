package faang.school.godbless.doCache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class WeaterData {
    private String city;
    private Double temperature;
    private Double humidity;

    public void setTempAndHum(Double temperature, Double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
