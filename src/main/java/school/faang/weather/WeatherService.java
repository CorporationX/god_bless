package school.faang.weather;

import java.util.concurrent.ThreadLocalRandom;

public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        return new WeatherData(city, rndTemperature(), rndHumidity(), System.currentTimeMillis());
    }

    private double rndTemperature() {
        double value = ThreadLocalRandom.current().nextDouble(-30.0, 50.0);
        return Math.round(value * 10.0) / 10.0;
    }

    private double rndHumidity() {
        double value = ThreadLocalRandom.current().nextDouble(0.0, 100.0);
        return Math.round(value * 10.0) / 10.0;
    }
}
