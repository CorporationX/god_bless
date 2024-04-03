package faang.school.godbless.BJS2_4134;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        System.out.println(weatherService.getWeatherByCity("Рязань"));
        System.out.println(weatherService.getWeatherByCity("Москва"));
        System.out.println(weatherService.getWeatherByCity("Санкт-Петербург"));
        weatherService.printCachedCities();

        weatherService.updateWeatherByCity("Москва", new WeatherData("Москва", 23, 33));
        System.out.println(weatherService.getWeatherByCity("Москва"));

        weatherService.removeWeatherByCity("Рязань");
        weatherService.printCachedCities();
    }

}
