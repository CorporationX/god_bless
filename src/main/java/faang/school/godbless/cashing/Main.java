package faang.school.godbless.cashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    private static Map<String, WeatherData> cache = new HashMap<>();

    public static void main(String[] args) {
        cache.put("New York", new WeatherData("New York", 25, 70));
        cache.put("Los Angeles", new WeatherData("Los Angeles", 30, 60));
        cache.put("London", new WeatherData("London", 20, 80));

        System.out.println("All cities:");
        printAllCitiesWeather();
        updateWeather( "London", 18, 55 );
        deleteWeatherForCity( "Los Angeles" );

        System.out.println("After deleting Los Angeles:");
        printAllCitiesWeather();
        System.out.println("Getting new weather for Los Angeles after deleting it:");
        System.out.println(getWeather( "Los Angeles" ));
        System.out.println("Fresh city weather:");

        printAllCitiesWeather();

    }

    public static WeatherData getWeather(String city){
        Random random = new Random();
        if(cache.containsKey( city )){
            return cache.get(city);
        }else{
            WeatherData weatherData = new WeatherData(city, random.nextInt(2) * 30, random.nextInt(2) * 45);
            cache.put(city, weatherData);
            return weatherData;
        }
    }
    public static void updateWeather(String city, int temperature, int humidity){
        WeatherData weatherData = cache.get(city);
        if(weatherData!=null){
            weatherData.setTemperature( temperature );
            weatherData.setHumidity( humidity );
        }else{
            weatherData = new WeatherData( city, temperature, humidity );
            cache.put( city, weatherData );
        }
    }
    public static void deleteWeatherForCity(String city){

        if(cache.containsKey( city ) ){
            cache.remove(city);
            System.out.println("Weather data for " + city + " removed from cache");
        }else{
            System.out.println("No data for this city in cache");
        }
    }
    public static void printAllCitiesWeather(){
        for(Map.Entry<String, WeatherData> weatherDataEntry: cache.entrySet()){
            System.out.println("City " + weatherDataEntry.getKey() + " weather " + weatherDataEntry.getValue());
        }
    }
}
