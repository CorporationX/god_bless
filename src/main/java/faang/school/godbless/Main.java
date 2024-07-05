package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        int[] reversed = Example.reverse(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(reversed[i]);
        }
        Weather.weatherMap.put("Moscow", new WeatherData("Moscow", 30, 78));
        Weather.weatherMap.put("London", new WeatherData("London", 30, 78));
        Weather.addWeatherIntoCache("Milan", new WeatherData("Milan", 40, 80));
        Weather.removeWeatherFromCache("London");
        System.out.println(Weather.citiesWithCachedWeather());
        System.out.println(Weather.findWeather("Akapulko").getTemperature());
        System.out.println(Weather.findWeather("Milan").getTemperature());
    }
}