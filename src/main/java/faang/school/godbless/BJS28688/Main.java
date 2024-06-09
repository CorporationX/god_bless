package faang.school.godbless.BJS28688;

public class Main {
    public static void main(String[] args) {
        CityWeatherMap cityWeatherMap = new CityWeatherMap();
        cityWeatherMap.addWeather(new WeatherData("Volgodonsk", 36.6, 30));
        cityWeatherMap.addWeather(new WeatherData("Córdoba", 22, 58));
        cityWeatherMap.printAllInfo();

        cityWeatherMap.removeWeather("Córdoba");
        cityWeatherMap.printAllInfo();

        cityWeatherMap.updateWeather(new WeatherData("Volgodonsk", 36.6, 40));
        cityWeatherMap.updateWeather(new WeatherData("Córdoba", 36.6, 40));
        cityWeatherMap.printAllInfo();

        System.out.println(cityWeatherMap.getWeather("Volgodonsk"));
        System.out.println(cityWeatherMap.getWeather("Córdoba"));
    }
}
