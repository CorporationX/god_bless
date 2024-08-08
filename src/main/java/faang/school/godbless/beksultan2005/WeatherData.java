package faang.school.godbless.beksultan2005;

public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city) {
        this.city = city;
        this.temperature = (int) (Math.random() * 45);
        this.humidity = (int) (Math.random() * 100);
    }
}
