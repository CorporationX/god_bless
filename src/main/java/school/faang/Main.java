package school.faang;

public class Main {
    public static void main(String[] args) {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
        for (int i = 0; i < 10; ++i) {
            standardWeatherCache.getWeatherData("Berlin", 8);
        }

        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        for (int i = 0; i < 10; ++i) {
            frequentUpdateWeatherCache.getWeatherData("London", 5);
        }
    }
}
