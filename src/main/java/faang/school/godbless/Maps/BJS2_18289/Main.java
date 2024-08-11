package faang.school.godbless.Maps.BJS2_18289;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherDataCaсhe = new HashMap<String, WeatherData>();

    public static void main(String[] args) {


    }

    public static WeatherData getWeatherData(String city){
        WeatherData data = weatherDataCaсhe.get(city);
        if(data == null){
            WeatherData mockWeatherData =  MockService.getDefaultData(city);
            weatherDataCaсhe.put(city, mockWeatherData);

            return mockWeatherData;
        }
        return data;
    }

    public static void updateWeatherDataCache(String city, int temperature, int humidity){
        weatherDataCaсhe.put(city,new WeatherData(city, temperature, humidity));
    }

    public static void removeData(String city){
        weatherDataCaсhe.remove(city);
    }

    public static void printCities(){
        for(Map.Entry<String, WeatherData> entry : weatherDataCaсhe.entrySet()){
            System.out.println(entry.getKey());
        }
    }

}


