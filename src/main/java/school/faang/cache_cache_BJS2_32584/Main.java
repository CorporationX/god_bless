package school.faang.cache_cache_BJS2_32584;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, WeatherData> weatherDataForCities = new HashMap<>();
    private WeatherSource weatherSource = new WeatherSource();

    public static void main(String[] args) {
        Main main = new Main();

        main.renewWeatherData("New York", 15.3, 60.5);
        main.renewWeatherData("London", 12.8, 70.3);
        main.renewWeatherData("Los Angeles", 23.7, 55.0);
        main.renewWeatherData("Tokyo", 28.5, 65.2);
        main.printWeatherData();
        main.deleteWeatherData("London");
        main.printWeatherData();
        System.out.println(main.getWeatherData("New York"));
        System.out.println(main.getWeatherData("Paris"));
    }

    public WeatherData getWeatherData(String city) {
        if (weatherDataForCities.containsKey(city)) {
            return weatherDataForCities.get(city);
        }
        weatherDataForCities.put(city, weatherSource.fetchWeather(city));
        return weatherSource.fetchWeather(city);
    }

    public void renewWeatherData(String city, double temperature, double humidity) {
        weatherDataForCities.put(city, new WeatherData(city, temperature, humidity));
    }

    public void deleteWeatherData(String city) {
        weatherDataForCities.remove(city);
    }

    public void printWeatherData() {
        for (Map.Entry<String, WeatherData> entry : weatherDataForCities.entrySet()) {
            System.out.printf("Weather for city %s : temperature - %.1f , humidity - %.1f\n"
                    , entry.getKey(), entry.getValue().getTemperature(), entry.getValue().getHumidity());
        }
    }

}