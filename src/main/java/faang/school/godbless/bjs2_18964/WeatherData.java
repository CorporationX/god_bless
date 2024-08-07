package faang.school.godbless.bjs2_18964;

import lombok.Builder;

@Builder
public class WeatherData {
    private String city;
    private int temperature;
    private int humidity;

    public void printData() {
        System.out.println("    Temperature: " + temperature);
        System.out.println("    Humidity: " + humidity);
    }
}
