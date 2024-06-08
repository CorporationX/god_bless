package faang.school.godbless;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return this.city;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getHumidity() {
        return this.humidity;
    }

    @Override
    public String toString() {
        return "|" + this.city + "| temperature: " + this.temperature + " humidity: " + this.humidity;
    }

    @Override
    public boolean equals(Object o) {
        return this.city == o.city && this.temperature == o.temperature && this.humidity == o.humidity;
    }
}