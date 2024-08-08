package faang.school.godbless.Mathew;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Main {
    static Map<String, WeatherData> cityWeather = new HashMap<>();

    public static WeatherData getWeatherOfCity(String city) {
        if (cityWeather.containsKey(city)) {
            return cityWeather.get(city);
        } else {
            WeatherData weatherData = new WeatherData(city);
            cityWeather.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeather(String city) {
        WeatherData weatherData = new WeatherData(city);
        cityWeather.put(city, weatherData);
    }

    public static void removeWeatherData(String city) {
        cityWeather.remove(city);
    }

    public static void getAllWeatherData() {
        cityWeather.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void main(String[] args) {
        WeatherData moscow = new WeatherData("Moscow");
        WeatherData segezha = new WeatherData("Segezha");
        WeatherData petrozavodsk = new WeatherData("Petrozavodsk");
        WeatherData spb = new WeatherData("Saints-Peterburg");
        WeatherData kazan = new WeatherData("Kazan");
        cityWeather.put("Мск",moscow);
        cityWeather.put("Спб",spb);
        cityWeather.put("Сегежа",segezha);
        cityWeather.put("Петрозаводск",petrozavodsk);
        cityWeather.put("Казань",kazan);
        getAllWeatherData();
        removeWeatherData("Moscow");
        getAllWeatherData();
        updateWeather("Алматы");
        getWeatherOfCity("Kazan");
    }
}
