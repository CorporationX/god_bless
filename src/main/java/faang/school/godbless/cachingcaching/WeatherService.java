package faang.school.godbless.cachingcaching;

public class WeatherService {
    public WeatherData getWeather(String city) {
        // Имитация получения данных из внешнего сервиса
        double temperature = Math.random() * 40; // случайная температура от 0 до 40°C
        double humidity = Math.random() * 100;  // случайная влажность от 0% до 100%
        return new WeatherData(city, temperature, humidity);
    }
}