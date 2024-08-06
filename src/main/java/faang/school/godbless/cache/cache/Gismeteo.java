package faang.school.godbless.cache.cache;

public class Gismeteo {

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
