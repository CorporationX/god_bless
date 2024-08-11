package faang.school.godbless;

public class WeatherData {
    private final String city;
    private final double temperature;
    private final double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        if (humidity < 0 || humidity > 100) {
            throw new IllegalArgumentException("Humidity must be between 0 and 100");
        }
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "WeatherData { " +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                " }";
    }
}
