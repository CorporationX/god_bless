package school.faang.sprint_1.task_44814;

import lombok.RequiredArgsConstructor;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@RequiredArgsConstructor
public class WeatherService implements WeatherProvider {

    @Override
    public WeatherData fetchWeatherData(String city) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.0", symbols);

        double temperature = Double.parseDouble(df.format(-50 + Math.random() * 100));
        double humidity = Double.parseDouble(df.format(Math.random() * 100));
        long timestamp = System.currentTimeMillis();

        WeatherData weatherData = new WeatherData(city, temperature, humidity, timestamp);
        return weatherData;
    }
}
