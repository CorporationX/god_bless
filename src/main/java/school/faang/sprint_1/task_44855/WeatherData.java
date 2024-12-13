package school.faang.sprint_1.task_44855;

public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final long timestamp;

    public WeatherData(String city, double temperature, double humidity, long timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

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

    public String toString() {
        return "WeatherData{" 
                + "city='" + city + '\'' 
                + ", temperature=" + temperature 
                + ", humidity=" + humidity 
                + ", timestamp=" + timestamp 
                + '}';
    }
}
