package faang.school.godbless.weather;

public class WeatherService {
    public WeatherData getWeather(String city) {
        // Имитация запроса к внешнему сервису.
        // Для примера возвращаем случайные данные.
        double temperature = Math.random() * 30; // Температура от 0 до 30
        double humidity = Math.random() * 100; // Влажность от 0 до 100
        return new WeatherData(city, temperature, humidity);
    }
}
