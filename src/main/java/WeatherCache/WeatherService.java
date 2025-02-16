package WeatherCache;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherService implements WeatherProvider {
    private static final Logger logger = Logger.getLogger(WeatherService.class.getName());

    @Override
    public WeatherData fetchWeatherData(String city) {
        try {
            Random random = new Random();
            double temperature = -30 + (80 * random.nextDouble());
            double humidity = 20 + (80 * random.nextDouble());
            return new WeatherData(city, temperature, humidity);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error while retrieving weather data for city: " + city, e);
            throw new RuntimeException("Error while retrieving weather data: ", e);
        }
    }
}
