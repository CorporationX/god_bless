package school.faang.bjs2_86067;

public class App {

    public static void main(String[] args) {
        final StandardWeatherCache standardWeatherCache = new StandardWeatherCache();
        final FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();

        WeatherData londonWeatherData = standardWeatherCache
                .getWeatherData(City.LONDON, System.currentTimeMillis());

        WeatherData parisWeatherData = standardWeatherCache
                .getWeatherData(City.PARIS, System.currentTimeMillis());

        WeatherData brazilWeatherData = frequentUpdateWeatherCache
                .getWeatherData(City.BRAZIL, System.currentTimeMillis() + 25000);

        WeatherData sochiWeatherData = frequentUpdateWeatherCache
                .getWeatherData(City.SOCHI, System.currentTimeMillis());

        WeatherData madridWeatherData = standardWeatherCache
                .getWeatherData(City.MADRID, System.currentTimeMillis() + 100);

        System.out.println(londonWeatherData);
        System.out.println(parisWeatherData);
        System.out.println(brazilWeatherData);
        System.out.println(sochiWeatherData);
        System.out.println(madridWeatherData);

        standardWeatherCache.forceUpdateWeather(City.MADRID);

        madridWeatherData = standardWeatherCache
                .getWeatherData(City.MADRID, System.currentTimeMillis() + 100);

        System.out.println(madridWeatherData);
    }
}