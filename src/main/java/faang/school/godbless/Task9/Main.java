package faang.school.godbless.Task9;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] arg) {

        Map<String, WeatherData> weather = new HashMap<>();
        WeatherData moscow = new WeatherData("Moscow", 25, 67);
        WeatherData paris = new WeatherData("Paris", 27, 71);
        WeatherData madrid = new WeatherData("Madrid", 31, 73);
        WeatherData london = new WeatherData("London", 24, 77);
        WeatherData milan = new WeatherData("Milan", 30, 78);
        weather.put(moscow.getCity(), moscow);
        weather.put(paris.getCity(), paris);
        weather.put(madrid.getCity(), madrid);
        weather.put(london.getCity(), london);
        weather.put(milan.getCity(), milan);

    }

}
