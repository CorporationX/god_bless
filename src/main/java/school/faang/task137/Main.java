package school.faang.task137;

public class Main {

    public static void main(String[] args) {
        WeatherData samara = new WeatherData("Samara", 6, 50);
        WeatherData moscow = new WeatherData("Moscow", 11, 99);
        WeatherData london = new WeatherData("London", 11, 97);

        WeatherDataService.putWeather(samara.getCity(), samara);
        WeatherDataService.putWeather(moscow.getCity(), moscow);
        WeatherDataService.putWeather(london.getCity(), london);

        WeatherDataService.printAllCityFromCache();
        System.out.println();

        System.out.println(WeatherDataService.getWeather(samara.getCity()).getTemperature());
        System.out.println();

        WeatherDataService.updateInfo(samara.getCity(), 15, 56);
        WeatherDataService.printAllCityFromCache();
        System.out.println();

        WeatherDataService.removeWeatherData(samara.getCity());
        WeatherDataService.printAllCityFromCache();
    }
}
