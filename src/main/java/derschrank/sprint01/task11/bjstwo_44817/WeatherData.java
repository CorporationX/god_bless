package derschrank.sprint01.task11.bjstwo_44817;

public record WeatherData(String city, double temperature, double humidity, long timestamp) {

    @Override
    public String toString() {
        return String.format("%s, temp: %3.0f°C, humidity: %3.0f%%", city, temperature, humidity);
    }
}
