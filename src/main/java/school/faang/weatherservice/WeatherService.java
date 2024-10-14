package school.faang.weatherservice;

public class WeatherService {
// Mock method to simulate retrieving weather data from an external source
public WeatherData fetchWeatherFromExternalSource(String city) {
    // Simulate some external weather data
    double simulatedTemperature = Math.random() * 30; // Random temperature between 0 and 30
    int simulatedHumidity = (int) (Math.random() * 100); // Random humidity between 0 and 100
    return new WeatherData(city, simulatedTemperature, simulatedHumidity);
}
}