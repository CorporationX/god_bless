package faang.school.godbless.cache.cache;

public class Gismeteo {

    private static final int MIN_TEMPERATURE = 20;
    private static final int MAX_TEMPERATURE = 35;
    private static final int MIN_HUMIDITY = 35;
    private static final int MAX_HUMIDITY = 70;

    public static WeatherData getWeather(String city) {

        WeatherData weatherData = new WeatherData();
        weatherData.setCity(city);
        weatherData.setTemperature(getRandomNumber(20, 35));
        weatherData.setHumidity(getRandomNumber(35, 70));

        return weatherData;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
