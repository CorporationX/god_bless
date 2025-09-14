package school.faang.BJS2_86058;

import java.util.Random;

public class WeatherService implements WeatherProvider {
    private final double minTemp = -29.0;
    private final double maxTemp = -29.0;
    private final int minHum = 0;
    private final int maxHum = 100;

    @Override
    public WeatherData fetchWeatherData(String city) {
        Random r = new Random();
        double rndTemp = minTemp + (maxTemp - minTemp) * r.nextDouble();
        double rndHum = minHum + (maxHum - minHum) * r.nextDouble();
        long timestamp = System.currentTimeMillis();
        return new WeatherData(city, rndTemp, rndHum, timestamp);
    }
}
