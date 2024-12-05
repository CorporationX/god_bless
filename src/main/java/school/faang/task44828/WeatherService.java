package school.faang.task44828;

import static school.faang.task44828.Weather.*;

public class WeatherService implements WeatherProvider {


    @Override
    public WeatherData fetchWeatherData(String city) {

        return new WeatherData(city,
                Math.random()
                        * (MAX_TEMP.getValue()
                        - MIN_TEMP.getValue())
                        + MIN_TEMP.getValue(),
                Math.random() * MAX_HUMIDITY.getValue(),
                System.currentTimeMillis());
    }
}
