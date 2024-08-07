package hashmap.cashing;

import lombok.NonNull;

import java.util.Random;

public class WeatherService {
    private static final Random rand = new Random();
    public static WeatherData getWeather(@NonNull String city) {
        WeatherData weatherData = new WeatherData(
                city,
                rand.nextInt(60) - 20,
                rand.nextInt(40) + 60
        );
        return weatherData;
    }
}
