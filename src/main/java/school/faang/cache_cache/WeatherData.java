package school.faang.cache_cache;

import java.util.Objects;

public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private long timestamp;

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WeatherData that = (WeatherData) o;
        return Double.compare(temperature, that.temperature) == 0
                && Double.compare(humidity, that.humidity) == 0 && timestamp == that.timestamp
                && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, temperature, humidity, timestamp);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", timestamp=" + timestamp +
                '}';
    }
}
