package faang.school.godbless.BJS2_18997;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
public class WeatherStorage {
    private final HashMap<String, WeatherData> storage = new HashMap<>();

    public WeatherData get(String city) {
        if (storage.containsKey(city)) {
            return storage.get(city);
        } else {
            WeatherData data = requestWeatherData(city);
            if (data != null) {
                storage.put(city, data);
            }
            return data;
        }
    }

    public void update(String city, double temperature, double humidity) {
        storage.put(city, new WeatherData(city, temperature, humidity));
    }

    public void remove(String city) {
        storage.remove(city);
    }

    public void printAllCities() {
        storage.forEach((city, weatherData) ->
                System.out.printf("Город: %s, Температура: %.1f, Влажность: %.1f%n",
                        city, weatherData.getTemperature(), weatherData.getHumidity()));
    }

    private WeatherData requestWeatherData(String city) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Exception in WeatherData.request()");
        }

        return switch (city) {
            case "Moscow" -> new WeatherData("Moscow", 23, 57.4);
            case "Paris" -> new WeatherData("Paris", 26, 45);
            case "Amsterdam" -> new WeatherData("Amsterdam", 24, 54.4);
            case "New York" -> new WeatherData("New York", 23, 55.4);
            default -> null;
        };
    }
}
