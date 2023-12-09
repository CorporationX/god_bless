package faang.school.godbless.BJS2_570;

class WeatherService {
    public static WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, 15.5, 57.0);
    }
}
