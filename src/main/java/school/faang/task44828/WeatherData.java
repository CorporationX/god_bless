package school.faang.task44828;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeatherData that = (WeatherData) o;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(city);
    }

    @Override
    public String toString() {
        Instant instant = Instant.ofEpochMilli(timestamp);
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        return "WeatherData:"
                + "city=" + city
                + ", temperature=" + String.format("%.1f", temperature)
                + ", humidity=" + String.format("%.1f", humidity)
                + ", time=" + formattedDateTime;
    }
}
