package faang.school.godbless.cashCash;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherData {
    private String city;
    private double temp;
    private double humidity;

    @Override
    public String toString() {
        return String.format("%s: %.2f градусов. %.2f Влажность.\n", city, temp, humidity);
    }
}
