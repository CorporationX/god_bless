package school.faang.BJS2_56884;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class WeatherData {

    private final String city;
    private Double temperature;
    private Double humidity;
    private long timestamp;

    public WeatherData(@NonNull String city) {
        if (city.isBlank()) {
            throw new IllegalArgumentException("Город не может быть пустым");
        }
        this.city = city;
    }
}
