package school.faang.bjs244832;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class WeatherData {
    private static final Logger logger = LoggerFactory.getLogger(WeatherData.class);

    private static final double ABSOLUTE_ZERO = -273.15;
    private static final int MIN_HUMIDITY = 0;
    private static final int MAX_HUMIDITY = 100;

    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        if (city == null || city.isEmpty()) {
            logger.error("City cannot be null or empty");
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        if (temperature < ABSOLUTE_ZERO) {
            logger.error("Temperature cannot be below absolute zero");
            throw new IllegalArgumentException("Temperature cannot be below absolute zero");
        }
        if (humidity < MIN_HUMIDITY || humidity > MAX_HUMIDITY) {
            logger.error("Humidity must be between 0 and 100");
            throw new IllegalArgumentException("Humidity must be between 0 and 100");
        }
        if (timestamp < 0) {
            logger.error("Timestamp cannot be negative");
            throw new IllegalArgumentException("Timestamp cannot be negative");
        }
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
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

        if (Double.compare(that.temperature, temperature) != 0) {
            return false;
        }
        if (Double.compare(that.humidity, humidity) != 0) {
            return false;
        }
        if (timestamp != that.timestamp) {
            return false;
        }
        return city.equals(that.city);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = city.hashCode();
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(humidity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "WeatherData{"
                + "city='" + city + '\''
                + ", temperature=" + temperature
                + ", humidity=" + humidity
                + ", timestamp=" + timestamp
                + '}';
    }
}