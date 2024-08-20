package faang.school.godbless.BJS2_19091;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class WeatherData {

    private String city;
    private int temperature;
    private int humidity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeatherData that)) return false;
        return getTemperature() == that.getTemperature() && getHumidity() == that.getHumidity() && Objects.equals(getCity(), that.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getTemperature(), getHumidity());
    }
}
