package faang.school.godbless.Mathew;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Main {
    static Map<String, WeatherData> mappa = new HashMap<>();

    public static WeatherData getWeatherOfCity(String city) {
        if (mappa.containsKey(city)) {
            return mappa.get(city);
        } else {
            WeatherData weatherData = new WeatherData(city);
            mappa.put(city, weatherData);
            return weatherData;
        }
    }

    public static void updateWeather(String city) {
        WeatherData weatherData = new WeatherData(city);
        mappa.put(city, weatherData);
    }

    public static void removeWeatherData(String city) {
        mappa.remove(city);
    }

    public static void getAllWeatherData() {
        mappa.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public static void main(String[] args) {
        WeatherData moscow = new WeatherData("Moscow");
        WeatherData segezha = new WeatherData("Segezha");
        WeatherData petrozavodsk = new WeatherData("Petrozavodsk");
        WeatherData spb = new WeatherData("Saints-Peterburg");
        WeatherData kazan = new WeatherData("Kazan");
        mappa.put("Мск",moscow);
        mappa.put("Спб",spb);
        mappa.put("Сегежа",segezha);
        mappa.put("Петрозаводск",petrozavodsk);
        mappa.put("Казань",kazan);
        getAllWeatherData();
        removeWeatherData("Moscow");
        getAllWeatherData();
        updateWeather("Алматы");
        getWeatherOfCity("Kazan");
    }
}
