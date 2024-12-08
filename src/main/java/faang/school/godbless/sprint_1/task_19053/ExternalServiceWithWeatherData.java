package faang.school.godbless.sprint_1.task_19053;

public class ExternalServiceWithWeatherData {

    public static WeatherData getWeatherData(String cityName) {
        return new WeatherData(new City(cityName), -5.5, 45);
    }
}
