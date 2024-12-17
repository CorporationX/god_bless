package school.faang.wecachwecachbjs44833;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class StandardWeatherCache extends WeatherCacheTemplate{
    private WeatherProvider provider;

    @Override
    protected WeatherData fetchFreshWeatherData(String city){
        return provider.fetchWeatherData(city);
    }
}
