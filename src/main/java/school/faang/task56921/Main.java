package school.faang.task56921;

import school.faang.task56921.weather.FrequentUpdateWeatherCache;
import school.faang.task56921.weather.StandardWeatherCache;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache();

        standardWeatherCache.getWeatherData("Сочи", 1000L);
        standardWeatherCache.getWeatherData("Сочи", 1000L);
        Thread.sleep(1000L);
        standardWeatherCache.getWeatherData("Сочи", 1000L);

        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        frequentUpdateWeatherCache.getWeatherData("Новосибирск", 10L);
    }
}
