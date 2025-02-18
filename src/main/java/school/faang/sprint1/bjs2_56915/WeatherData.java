package school.faang.sprint1.bjs2_56915;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EqualsAndHashCode
@ToString
@Setter
@Getter
public class WeatherData {
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherData.class);
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(@NonNull String city) {
        if (city.isBlank()) {
            String message = "Значение 'Город' не может быть пустым";
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
        this.city = city;
        LOGGER.debug("Объект WeatherData создан для города: {}", city);
    }
}
