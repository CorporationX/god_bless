package faang.school.godbless.cashCash;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> weatherData = new HashMap<>();
    public static void main(String[] args) {
        weatherData.put("Moscow", new WeatherData("Moscow", 23.4, 50));
        weatherData.put("Berlin", new WeatherData("Berlin", 18, 70));

        System.out.print(getWeatherData("Moscow").toString());
        System.out.print(getWeatherData("Berlin").toString());
        System.out.println(getWeatherData("САРАТОВ").toString());
        weatherData.forEach( ( city, data ) ->
        {
            System.out.print(data.toString());
        });
    }

    public static WeatherData getWeatherData(String city) {
        if (weatherData.containsKey(city))
        {
            return weatherData.get(city);
        }

        System.out.println("Погода не найдена в кеше, обращаемся к надёжному источнику");

        WeatherData newWeatherData = WeatherSource.getWeather(city);
        weatherData.put(city, newWeatherData);

        return newWeatherData;
    }
}
