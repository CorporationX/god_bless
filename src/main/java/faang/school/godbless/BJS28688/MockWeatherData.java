package faang.school.godbless.BJS28688;

public class MockWeatherData {
    public static WeatherData getWeather(String city) {
        WeatherData result = new WeatherData();
        result.setCity(city);
        return result;
    }
}
