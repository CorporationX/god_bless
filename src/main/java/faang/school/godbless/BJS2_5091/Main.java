package faang.school.godbless.BJS2_5091;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, WeatherData> weatherData = new HashMap<>();

        WeatherData.getWeatherByCity(weatherData, "London");
        WeatherData.printAllWeatherCity(weatherData);

        WeatherData londonWeather = new WeatherData("London", 20, 80);
        WeatherData.updateWeather(weatherData, londonWeather);
        WeatherData.printAllWeatherCity(weatherData);

        WeatherData stambulWeather = WeatherData.getWeatherByCity(weatherData, "Stambul");
        System.out.println(stambulWeather);

        System.out.println("удаляем погоду");
        WeatherData.removeWeather(weatherData, "Stambul");
        WeatherData.printAllWeatherCity(weatherData);

    }
}
