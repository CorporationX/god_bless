package faang.school.godbless.CachingCaching;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<String, WeatherData> WHETHER_DATA = new HashMap<>();

    public static void main(String[] args) {

        Main app = new Main();

        app.update("Tallinn", new WeatherData("Tallinn", 20.0, 70.0));
        app.update("San Francisco", new WeatherData("San Francisco", 30.0, 50.0));
        app.update("Paris", new WeatherData("Paris", 18.0, 40.0));

        WeatherData data = app.get("Tallinn");
        System.out.println("City: " + data.getCity() +
                ", Temperature: " + data.getTemperature() +
                ", Humidity: " + data.getHumidity());

        app.delete("Tallinn");

        System.out.println();

        for (Map.Entry<String, WeatherData> entry : app.getAll().entrySet()) {
            String city = entry.getKey();
            WeatherData weatherData = entry.getValue();
            System.out.println("City: " + city +
                    ", Temperature: " + weatherData.getTemperature() +
                    ", Humidity: " + weatherData.getHumidity());
        }
    }

    public WeatherData get(String city) {
        MockService mockService = new MockService();
        return WHETHER_DATA.computeIfAbsent(city, key -> mockService.getCache());
    }

    public void update(String city, WeatherData data) {
        WHETHER_DATA.put(city, data);
    }

    public void delete(String city) {
        WHETHER_DATA.remove(city);
    }

    public Map<String, WeatherData> getAll() {
        return new HashMap<>(WHETHER_DATA);
    }


}
