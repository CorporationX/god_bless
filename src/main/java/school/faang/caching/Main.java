package school.faang.caching;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        System.out.println(service.getWeather("Питер"));
        System.out.println(service.getWeather("Душанбе"));
        System.out.println(service.getWeather("Париж"));
        System.out.println(service.getWeather("London"));

        service.listCity();

        WeatherData newWeatherData = new WeatherData("Питер", 5.0, 80.0);
        service.updateWeatherDate("Питер", newWeatherData);
        System.out.println(service.getWeather("Питер"));

        service.removeWeatherDate("London");
        service.listCity();
    }

}
