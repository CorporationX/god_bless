package faang.school.godbless.beksultan2005;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, WeatherData> cacheData = new HashMap<>();

    public WeatherData getWeatherData(String city){
        if(cacheData.containsKey(city)){
            return cacheData.get(city);
        }else{
            WeatherData weatherData = new WeatherData(city);
            cacheData.put(city, weatherData);
            return weatherData;
        }
    }

    public void updateWeatherData(String city){
        if(cacheData.containsKey(city)){
            cacheData.put(city, new WeatherData(city));
        }
    }

    public void removeWeatherData(String city){
        if(cacheData.containsKey(city)){
            cacheData.remove(city);
        }
    }

    public void getAllWeatherData(){
        cacheData.forEach((key, value) -> System.out.println(key + ":" + value.toString()));
    }

    public static void main(String[] args) {
        Main weatherApp = new Main();

        System.out.println(weatherApp.getWeatherData("Almaty"));
        weatherApp.getAllWeatherData();
        weatherApp.updateWeatherData("Almaty");
        System.out.println(weatherApp.getWeatherData("Almaty"));
        weatherApp.getAllWeatherData();
        weatherApp.removeWeatherData("Almaty");
        weatherApp.getAllWeatherData();
    }
}
