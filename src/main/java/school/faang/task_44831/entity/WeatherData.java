package school.faang.task_44831.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class WeatherData {
    private final String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(String city) {
        if (StringUtils.isBlank(city)) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }
}
