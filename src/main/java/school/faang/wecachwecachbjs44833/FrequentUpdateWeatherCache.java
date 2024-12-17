package school.faang.wecachwecachbjs44833;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class FrequentUpdateWeatherCache extends WeatherCacheTemplate{
    private WeatherProvider provider;

    @Override
    protected WeatherData fetchFreshWeatherData(String city){
        return provider.fetchWeatherData(city);
    }

    @Override
    protected boolean isDataFresh(WeatherData data, long maxCacheAgeMilles){
        return (System.currentTimeMillis() - data.getTimestamp()) < maxCacheAgeMilles;
    }
}
