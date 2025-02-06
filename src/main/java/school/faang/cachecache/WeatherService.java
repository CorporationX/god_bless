package school.faang.cachecache;

public class WeatherService implements WeatherProvider {
    @Override
    public WeatherData fetchWeatherData(String city) {
        double temperature = -35 + Math.random() * 75; // Генерация значения температуры от -35 до 40
        double humidity = Math.random() * 100; // Генерация значения влажности от 0 до 100
        long timestamp = System.currentTimeMillis(); // Добыча текущего времени
        return new WeatherData(city, temperature, humidity, timestamp);
    }
}
