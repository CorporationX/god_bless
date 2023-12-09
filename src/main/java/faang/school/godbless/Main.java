package faang.school.godbless;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> mapWeather = new HashMap<>();
        WeatherData wd1 = new WeatherData("Almaty", 2, 45);
        ExternalService es = new ExternalService();
        mapWeather.put(wd1.getCity(), wd1);
        System.out.println(weatherInfo(mapWeather, "Almat", es));
        listAllCity(mapWeather);
        System.out.println(updateInfo(mapWeather, "Almaty", -3, 70));
        System.out.println(deleteInfo(mapWeather, "Almat"));
    }
    public static String weatherInfo(Map<String, WeatherData> mapWeather, String city, ExternalService es){
        String s=null;
        for (Map.Entry<String, WeatherData> entry : mapWeather.entrySet()) {
            if(entry.getKey().equals(city)){
                s = entry.getValue().toString();
            } else {
                System.out.println("There are no info about this city");
                mapWeather.put(es.getInfoWeather(city), null);
                System.out.println("Added information to the cache "+mapWeather.keySet());
            }
        }
        return s;
    }
    public static Map<String, WeatherData> updateInfo(Map<String, WeatherData> cache, String city, double newTemperature, double newHumidity){
        if(cache.containsKey(city)){
            cache.put(city, new WeatherData(city, newTemperature, newHumidity));
        }
        return cache;
    }
    public static Map<String, WeatherData> deleteInfo(Map<String, WeatherData> cache, String city){
        Iterator<Map.Entry<String,WeatherData>> iterator = cache.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, WeatherData> entry = iterator.next();
            if(entry.getKey().equals(city)){
                iterator.remove();
            }
        }
        return cache;
    }
    public static String listAllCity(Map<String, WeatherData> cache){
        for (Map.Entry<String, WeatherData> entry : cache.entrySet()) {
            if(entry.getValue() != null){
                System.out.println(entry);
            }
        }
        return cache.toString();
    }

}
