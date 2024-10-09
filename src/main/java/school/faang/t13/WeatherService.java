package school.faang.t13;

class WeatherService {
    public static WeatherData getWeatherData(String city) {
        return new WeatherData(city, Math.random() * 30,  Math.random() * 100);
    }
}