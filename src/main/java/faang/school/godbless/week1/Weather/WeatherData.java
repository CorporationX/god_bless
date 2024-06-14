package faang.school.godbless.week1.Weather;

public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
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

    @Override
    public String toString() {
        return "WeatherData{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
