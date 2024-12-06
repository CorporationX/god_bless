package school.faang.sprint_1.task_44835;

import school.faang.sprint_1.task_44835.service.WeatherService;

public class Main {
    public static void main(String[] args) {
        var weatherService = new WeatherService();
        System.out.println(weatherService.fetchWeatherData("Moscow"));
    }
}
