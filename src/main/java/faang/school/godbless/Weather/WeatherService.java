package faang.school.godbless.Weather;


import java.util.Random;

public class WeatherService {
    public static final String[] DESCRIPTIONS = {"Sunny", "Cloudy", "Rainy", "Stormy"};

    public static WeatherData getWeatherDataFromExternalService(String city){
        Random random = new Random();
        int temperature = random.nextInt(30);
        int humidity = random.nextInt(100);
        String description = DESCRIPTIONS[random.nextInt(DESCRIPTIONS.length)];
        return new WeatherData(city, temperature, humidity, description);
    }
}
