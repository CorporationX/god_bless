package faang.school.godbless.BJS2_19030;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Main {

    static Map<String, WeatherData> citiesWeather = new HashMap<>(
            Map.of(
                    "St.Petersburg", new WeatherData("St.Petersburg", 18.3, 90),
                    "Yekaterinburg", new WeatherData("Yekaterinburg", 25.2, 70),
                    "Chelyabinsk", new WeatherData("Chelyabinsk", 27.2, 65)));

    public static void main(String[] args) {

        System.out.println(getWeatherByCity("Chelyabinsk"));
        System.out.println(getWeatherByCity("Yekaterinburg"));
        System.out.println(getWeatherByCity("Omsk"));
        System.out.println(getWeatherByCity("Krasnoyarsk"));
        System.out.println(getWeatherByCity("Vladivostok"));
        System.out.println(getWeatherByCity("Moscow"));
    }

    static WeatherData getWeatherByCity(String city) {
        if (!citiesWeather.containsKey(city)) {
            citiesWeather.put(city, loadWeatherDataFromSite(city));
        }

        return citiesWeather.get(city);
    }

    static WeatherData loadWeatherDataFromSite(String city) {
        Random random = new Random();
        return new WeatherData(city,
                Math.round(random.nextDouble(10d, 30d)),
                random.nextInt(50, 100));
    }

}
