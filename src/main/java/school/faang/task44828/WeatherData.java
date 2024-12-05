package school.faang.task44828;

import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static school.faang.task44828.Weather.*;

@Getter
public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        validation(city, temperature, humidity, timestamp);

        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    public void validation(String city, double temperature, double humidity, long timestamp) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or blank");
        }
        if (temperature >= MAX_TEMP.getValue() || temperature <= MIN_TEMP.getValue()) {
            throw new IllegalArgumentException("Temperature must be between "
                    + MIN_TEMP.getValue()
                    + " and " + MAX_TEMP.getValue());
        }
        if (humidity >= MAX_HUMIDITY.getValue() || humidity <= MIN_HUMIDITY.getValue()) {
            throw new IllegalArgumentException("Humidity must be between "
                    + MIN_HUMIDITY.getValue()
                    + " and " + MAX_HUMIDITY.getValue());
        }
        if (timestamp < MIN_TIMESTAMP.getValue()) {
            throw new IllegalArgumentException("Timestamp must be more than " + MIN_TIMESTAMP.getValue());
        }
    }

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
                + "city="
                + city + ", temperature=" + String.format("%.1f", temperature)
                + ", humidity=" + String.format("%.1f", humidity)
                + ", time=" + formattedDateTime;
    }
}
