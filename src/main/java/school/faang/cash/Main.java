package school.faang.cash;

import school.faang.main_code.Mock;
import school.faang.main_code.WeatherData;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, WeatherData> temperatureCity = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        Mock mock = new Mock();


    }

    public WeatherData getInfo(String cityName, Mock mock) {
        if (!temperatureCity.containsKey(cityName)) {
            temperatureCity.put(mock.getWeatherData().getCity(), mock.getWeatherData());
        }

        return temperatureCity.get(cityName);
    }

    public void refreshInfo(String name, int temperature, int humidity) {
        WeatherData weatherData = new WeatherData(name, temperature, humidity);
        temperatureCity.replace(name, weatherData);
    }

    public void removeInfo(String name) {
        temperatureCity.remove(name);
    }

    public void printAll() {
        for (Map.Entry<String, WeatherData> entry : temperatureCity.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
