package src.main.java.faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<String,WeatherData>map = new HashMap<>();

    public static void meteocentr (String city){
        if (map.containsKey(city)) {
            WeatherData weatherData = map.get(city);
            System.out.println("Город: " + weatherData.getCity());
            System.out.println("Температура: " + weatherData.getTemperature() + "°C");
            System.out.println("Влажность: " + weatherData.getHumidity() + "%");
        } else {
          WeatherData weatherData =  MeteoService.getWeather(city);
          map.put(city, weatherData);
          System.out.println("Город: " + weatherData.getCity());
          System.out.println("Температура: " + weatherData.getTemperature() + "°C");
          System.out.println("Влажность: " + weatherData.getHumidity() + "%");
        }
    }
    public void update (String city, WeatherData weatherData){
        map.put(city,weatherData);
    }
    public void remove (String city){
        map.remove(city);
    }
    public void soutCity(){
        Set<String> cities = map.keySet();
        for (String city : cities){
            System.out.println(city);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        WeatherData msk = new WeatherData("Moscow",2, 50);
        WeatherData msk2 = new WeatherData("Moscow",1, 40);
        WeatherData spb = new WeatherData("Saint P",0, 90);
        map.put("Moscow",msk);
        map.put("Saint P",spb);
        meteocentr("Moscow");
        main.update("Moscow", msk2);
        main.remove("Moscow");
        meteocentr("Moscow");
        main.soutCity();

    }
}
