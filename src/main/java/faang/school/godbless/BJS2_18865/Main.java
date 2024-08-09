package faang.school.godbless.BJS2_18865;

public class Main {

    // Сделал немного иначе нежели было в условии так как мне показалось что делать
    // это дело в Меине это странно и неудобно

    public static void main(String[] args) {
        WeatherGetterService weatherService = new WeatherGetterService();

        System.out.println(weatherService.getFor("Moscow"));
        System.out.println(weatherService.getFor("Warsaw"));
        System.out.println(weatherService.getFor("Amsterdam"));
        System.out.println(weatherService.getFor("Paris"));
        System.out.println(weatherService.getFor("Warsaw"));
        System.out.println(weatherService.getFor("Paris"));

        System.out.println();
        weatherService.weatherCacheService.printAllCache();

        weatherService.weatherCacheService.editData("Warsaw", new WeatherData("Warsaw", 10.0f, 23.5f));
        System.out.println();
        weatherService.weatherCacheService.printAllCache();

        weatherService.weatherCacheService.removeData("Paris");
        System.out.println();
        weatherService.weatherCacheService.printAllCache();
    }


}
