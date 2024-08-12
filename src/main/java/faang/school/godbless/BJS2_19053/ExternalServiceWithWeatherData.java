package faang.school.godbless.BJS2_19053;

public class ExternalServiceWithWeatherData {

    public static WeatherData getWeatherData(String cityName) {
        return new WeatherData(new City(cityName), -5.5, 45);
    }
}
