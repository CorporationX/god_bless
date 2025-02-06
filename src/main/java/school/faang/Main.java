package school.faang;

import school.faang.service.WeatherData;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData("Екатеринбург", -15.2, 85.4, System.currentTimeMillis());
        System.out.println(weatherData);
    }
}