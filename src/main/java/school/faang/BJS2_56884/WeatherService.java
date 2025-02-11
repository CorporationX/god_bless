package school.faang.BJS2_56884;

import java.util.Random;

public class WeatherService implements WeatherProvider {

    private static final double MIN_TEMP = -30;
    private static final double MAX_TEMP = 50;
    private static final double MIN_HUMIDITY = 0;
    private static final double MAX_HUMIDITY = 100;

    @Override
    public WeatherData fetchWeatherData(String city) {
        WeatherData data = new WeatherData(city);
        setWeatherData(data);
        return data;
    }

    private void setWeatherData(WeatherData data) {
        Random random = new Random();
        double temperature = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble();
        double humidity = MIN_HUMIDITY + (MAX_HUMIDITY - MIN_HUMIDITY) * random.nextDouble();
        long timestamp = System.currentTimeMillis();
        data.setTemperature(temperature);
        data.setHumidity(humidity);
        data.setTimestamp(timestamp);
    }
}
