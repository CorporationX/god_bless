package faang.school.godbless.caching;

import lombok.AllArgsConstructor;

import java.text.DecimalFormat;

@AllArgsConstructor
public class WeatherData {
    private static final DecimalFormat ONE_DECIMAL = new DecimalFormat("#.0");

    private String city;
    private double temperature;
    private int humidity;

    @Override
    public String toString() {
        return "Сведения о погоде {" +
                "город = " + city +
                ", температура = " + ONE_DECIMAL.format(temperature) + " град. С" +
                ", влажность = " + humidity + " %" +
                '}';
    }
}
