package school.faang.hash_hash;

public class Main {

    public static void main(String[] args) {
        StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

        System.out.println(standardWeatherCache.getWeatherData("London", 1000).toString());
        System.out.println(standardWeatherCache.getWeatherData("Moskow", 500).toString());
        System.out.println(frequentUpdateWeatherCache.getWeatherData("London", 10000).toString());
        System.out.println(frequentUpdateWeatherCache.getWeatherData("Moskow", 100).toString());
    }
}
