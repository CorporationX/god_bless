package faang.school.godbless.bjs2_18832;


import lombok.ToString;


import java.util.Map;

@ToString
public class WeatherData {

    private String city;
    private int temperature;
    private int humidity;

    public WeatherData(String city, int temperature, int humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public static WeatherData getWeatherData(Map<String, WeatherData> cityInfo, String city) {
        if (!cityInfo.containsKey(city)) {
            cityInfo.put(city, WeatherDataService.randomWeather(city));
        }
        return cityInfo.get(city);
    }

    public static void informationUpdate(String city, Map<String, WeatherData> cityInfo, WeatherData weatherData) {
        cityInfo.put(city, weatherData);
    }

    public static void informationDelete(String city, Map<String, WeatherData> cityInfo) {
        cityInfo.remove(city);
    }

    public static void informationOutput(Map<String, WeatherData> cityInfo) {
        for (String city : cityInfo.keySet()) {
            System.out.println(city);
        }
    }
}
