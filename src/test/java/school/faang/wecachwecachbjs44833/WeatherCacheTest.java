package school.faang.wecachwecachbjs44833;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherCacheTest {
    @Test
    public void testStandartWeatherCache(){
        WeatherService service = new WeatherService();
        StandardWeatherCache cache = new StandardWeatherCache(service);

        WeatherData data1 = cache.getWeatherData("Moscow", 10000);
        assertNotNull(data1);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){

        }

        WeatherData data2 = cache.getWeatherData("Moscow", 10000);
        assertSame(data1, data2);
    }

    @Test
    public void testFrequentUpdateWeatherCache(){
        WeatherService service = new WeatherService();
        FrequentUpdateWeatherCache cache = new FrequentUpdateWeatherCache(service);

        WeatherData data1 = cache.getWeatherData("Moscow", 1000);
        assertNotNull(data1);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e){

        }

        WeatherData data2 = cache.getWeatherData("Moscow", 1000);
        assertSame(data1, data2);
    }

    @Test
    public void testClearExpiredCache(){
        WeatherService service = new WeatherService();
        StandardWeatherCache cache = new StandardWeatherCache(service);

        cache.getWeatherData("Moscow", 10000);
        cache.clearExpiredCache(5000);

        WeatherData data = cache.getWeatherData("Moscow", 10000);
        assertNotNull(data);
    }
}
