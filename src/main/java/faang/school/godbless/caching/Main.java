package faang.school.godbless.caching;


public class Main {
    public static void main(String[] args) {
        WeatherIndex weatherIndex = new WeatherIndex();

        Weather luxembourgWeather = weatherIndex.getWeather("Luxembourg");
        Weather moscowWeather = weatherIndex.getWeather("Moscow");
        Weather londonWeather = weatherIndex.getWeather("London");

        System.out.println(luxembourgWeather);
        System.out.println(moscowWeather);
        System.out.println(londonWeather);

        weatherIndex.updateCityWeather("Luxembourg");

        System.out.println("All Weathers");
        weatherIndex.showAllWeatherDate();

        System.out.println("All Weathers after deleting londonWeather");
        weatherIndex.deleteCityWeather("London");
        weatherIndex.deleteCityWeather("London");
        weatherIndex.showAllWeatherDate();
    }
}
