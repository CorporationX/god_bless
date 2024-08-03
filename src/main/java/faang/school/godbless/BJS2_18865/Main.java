package faang.school.godbless.BJS2_18865;

public class Main {

    // Сделал немного иначе нежели было в условии так как мне показалось что делать
    // это дело в Меине это странно и неудобно

    public static void main(String[] args) {
        WeatherDataGetterService weatherDataGetterService = new WeatherDataGetterService();

        System.out.println(weatherDataGetterService.getCityToWeatherData("Moscow"));
        System.out.println(weatherDataGetterService.getCityToWeatherData("Warsaw"));
        System.out.println(weatherDataGetterService.getCityToWeatherData("Amsterdam"));
        System.out.println(weatherDataGetterService.getCityToWeatherData("Paris"));
        System.out.println(weatherDataGetterService.getCityToWeatherData("Warsaw"));
        System.out.println(weatherDataGetterService.getCityToWeatherData("Paris"));

        System.out.println();
        weatherDataGetterService.weatherDataCacheService.printAllCacheData();

        weatherDataGetterService.weatherDataCacheService.editCityWeatherData("Warsaw", new WeatherData("Warsaw", 10.0f, 23.5f));
        System.out.println();
        weatherDataGetterService.weatherDataCacheService.printAllCacheData();

        weatherDataGetterService.weatherDataCacheService.removeCityWeatherData("Paris");
        System.out.println();
        weatherDataGetterService.weatherDataCacheService.printAllCacheData();
    }


}
