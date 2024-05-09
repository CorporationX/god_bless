package faang.school.godbless.java_hashmap.BJS2_5634;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        System.out.println(weatherService.getWeatherByCity("Paphos"));
        System.out.println(weatherService.getWeatherByCity("Larnaca"));
        System.out.println(weatherService.getWeatherByCity("Moscow"));
        weatherService.printCachedCities();

        weatherService.updateWeatherByCity("Moscow", new WeatherData("Moscow", 23, 33));
        System.out.println(weatherService.getWeatherByCity("Moscow"));

        weatherService.removeWeatherByCity("Paphos");
        weatherService.printCachedCities();
    }
}
