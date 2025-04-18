package school.faang.bjs2_68918;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        int minTemp = 18;
        int maxTemp = 25;
        int minHumidity = 30;
        int maxHumidity = 60;
        return new WeatherData(
                city,
                minTemp + Math.random() * (maxTemp - minTemp),
                minHumidity + Math.random() * (maxHumidity - minHumidity),
                System.currentTimeMillis()
        );
    }
}
