package school.faang.BSJ2_87000;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData;
        StandardWeathCache standardWeathCache = new StandardWeathCache();
        weatherData = standardWeathCache.getWeatherData("Almaty", 1000);
        printWeatherData(weatherData);
        weatherData = standardWeathCache.getWeatherData("Moscow", 1000);
        printWeatherData(weatherData);
        weatherData = standardWeathCache.getWeatherData("Moscow", 1000000);
        printWeatherData(weatherData);
        weatherData = standardWeathCache.getWeatherData("Almaty", 1);
        printWeatherData(weatherData);

        FrequentUpdateWeatherCache frequentUpdateWeatherCache = new FrequentUpdateWeatherCache();
        weatherData = frequentUpdateWeatherCache.getWeatherData("Moscow", 10000000);
        printWeatherData(weatherData);
    }

    private static void printWeatherData(WeatherData weatherData) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.printf("Weather in %s is: temperature = %s, humidity = %s\n",
                weatherData.getCity(),
                decimalFormat.format(weatherData.getTemperature()),
                decimalFormat.format(weatherData.getHumidity()));
    }
}
