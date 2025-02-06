package school.faang;

import school.faang.service.WeatherData;
import school.faang.service.WeatherService;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        System.out.println(weatherService.fetchWeatherData("Екатеринбург"));
    }
}