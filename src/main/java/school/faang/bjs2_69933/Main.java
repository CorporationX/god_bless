package school.faang.bjs2_69933;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StandardWeatherCache stdWeatherCash = new StandardWeatherCache();
        FrequentUpdateWeatherCache freqWeatherCash = new FrequentUpdateWeatherCache();

        System.out.println(stdWeatherCash.getWeatherData("Moscow", 7_000));
        System.out.println(freqWeatherCash.getWeatherData("Cheboksary", 7_000));
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stdWeatherCash.getWeatherData("Moscow", 7_000));
        System.out.println(freqWeatherCash.getWeatherData("Cheboksary", 7_000));

        stdWeatherCash.clearExpiredCache(10_000);

        for (Map.Entry<String, WeatherData> entry : stdWeatherCash.weatherCash.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
