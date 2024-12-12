package school.faang.task_44872;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherData{" + "city='"
                + city + '\'' + ", temperature="
                + temperature + ", humidity="
                + humidity + ", timestamp="
                + timestamp + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeatherData that = (WeatherData) o;
        return Double.compare(temperature, that.temperature) == 0
                && Double.compare(humidity, that.humidity) == 0
                && timestamp == that.timestamp
                && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity, timestamp);
    }
}
