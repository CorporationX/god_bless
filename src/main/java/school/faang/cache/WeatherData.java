package school.faang.cache;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class WeatherData {
    public final String city;
    public final double temperature;
    public final double humidity;
    public final long timestamp = System.currentTimeMillis();

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
