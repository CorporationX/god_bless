package faang.school.godbless.Maps.BJS2_18289;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, WeatherData> weatherDataCash = new HashMap<String, WeatherData>();

    public static void main(String[] args) {


    }

    public static WeatherData getWeatherData(String city){
        WeatherData data = weatherDataCash.get(city);
        if(data == null){
            WeatherData mockWeatherData =  MockService.getDefaultData(city);
            weatherDataCash.put(city, mockWeatherData);

            return mockWeatherData;
        }
        return data;
    }

    public static void updateWeatherDataCash(String city, int temperature, int humidity){
        weatherDataCash.put(city,new WeatherData(city, temperature, humidity));
    }

    public static void removeData(String city){
        weatherDataCash.remove(city);
    }

    public static void printCities(){
        for(Map.Entry<String, WeatherData> entry : weatherDataCash.entrySet()){
            System.out.println(entry.getKey());
        }
    }

}


