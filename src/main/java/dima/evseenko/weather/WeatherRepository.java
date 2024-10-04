package dima.evseenko.weather;

import java.util.List;

public class WeatherRepository {
    private static final List<WeatherData> weatherDataList = List.of(
            new WeatherData("Санкт-Петербург", 9, 91),
            new WeatherData("Москва", 12, 79),
            new WeatherData("Екатеринбург", 16, 25),
            new WeatherData("Ростов-на-Дону", 24, 25),
            new WeatherData("Краснодар", 25, 34),
            new WeatherData("Воронеж", 22, 23)
    );

    public static WeatherData getWeather(String city){
        for (WeatherData weatherData : weatherDataList) {
            if (weatherData.getCity().equals(city)) {
                return weatherData;
            }
        }
        return null;
    }
}
