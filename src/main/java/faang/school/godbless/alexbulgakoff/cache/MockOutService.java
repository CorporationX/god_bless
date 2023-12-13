package faang.school.godbless.alexbulgakoff.cache;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class MockOutService {
    WeatherData weatherRio = new WeatherData("Rio de Janeiro", 26, 87);
    WeatherData weatherBarcelona = new WeatherData("Barcelona", 16, 68);
    List<WeatherData> weatherDataList = Arrays.asList(weatherRio, weatherBarcelona);

    public WeatherData getWeather(String city) {
        for (WeatherData data : weatherDataList) {
            if (data.getCity().equals(city)) {
                return data;
            }
        }
        return null;
    }
}
