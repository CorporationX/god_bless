package faang.school.godbless.bjs2_18964;

public class Main {
    public static void main(String[] args) {
        var weatherService = WeatherService.getInstance();

        var weatherMoscow = weatherService.getWeatherDataByCity("Moscow");
        var weatherMinsk = weatherService.getWeatherDataByCity("Minsk");
        weatherMoscow.printData();
        weatherMinsk.printData();
        System.out.println("----------------");

        weatherService.printWeather();
        System.out.println("----------------");

        var weatherMinskRepeat = weatherService.getWeatherDataByCity("Minsk");
        weatherService.printWeather();
        System.out.println("----------------");

        weatherService.updateWeatherForCity("Minsk");
        weatherService.printWeather();
        System.out.println("----------------");

        weatherService.removeWeatherForCity("Minsk");
        weatherService.printWeather();
        System.out.println("----------------");
    }
}
