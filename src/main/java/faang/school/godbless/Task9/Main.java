package faang.school.godbless.Task9;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static WeatherData getCityInfo(String cityName, Map<String, WeatherData> weather) {
        if (weather.get(cityName) == null) {
            WeatherData newData = Connection.connectToServer(cityName);
            weather.put(cityName, newData);
            return newData;
        } else {
            return weather.get(cityName);
        }
    }

    public static void updateInfo(String city, int temperature, int humidity,
                                  Map<String, WeatherData> weather) {
        weather.computeIfPresent(city, (key, value)-> new WeatherData(city, temperature, humidity));
    }

    public static void removeInfo(String city, Map<String, WeatherData> weather) {
        if (weather.get(city)==null) {
            throw new IllegalArgumentException("the city was not found");
        } else {
            weather.remove(city);
        }
    }

    public static void showAllInfo(Map<String, WeatherData> weather) {
        for (Map.Entry<String, WeatherData> entry : weather.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getTemperature() + " degree(s) " +
                    entry.getValue().getHumidity() + " %");
        }
    }

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
        System.out.println(weather);

        System.out.println(getCityInfo("Milan", weather));
        System.out.println(getCityInfo("Amsterdam", weather));
        updateInfo("Milan", 29, 75, weather);
        System.out.println(getCityInfo("Milan", weather));
        removeInfo("Moscow", weather);
        //removeInfo("Dallas", weather); 
        System.out.println(weather);
        showAllInfo(weather);

    }

}
