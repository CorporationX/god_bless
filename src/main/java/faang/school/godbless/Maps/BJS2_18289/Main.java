//package faang.school.godbless.Maps.BJS2_18289;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Main {
//    private static Map<String, WeatherData> weatherDataCaсhe = new HashMap<String, WeatherData>();
//
//    public static void main(String[] args) {
//
//        weatherDataCaсhe.put("London", new WeatherData("London", 20, 80));
//        weatherDataCaсhe.put("London", new WeatherData("Bagdad", 40, 10));
//        weatherDataCaсhe.put("London", new WeatherData("Moscow", 25, 40));
//
//        System.out.println(getWeatherData("London"));
//        System.out.println(getWeatherData("Monako"));
//
//
//    }
//
//    public static WeatherData getWeatherData(String city){
//        weatherDataCaсhe.computeIfAbsent(city, k->MockService.getDefaultData(k));
//        WeatherData data = weatherDataCaсhe.get(city);
//
//        return data;
//    }
//
//    public static void updateWeatherDataCache(String city, int temperature, int humidity){
//        weatherDataCaсhe.put(city,new WeatherData(city, temperature, humidity));
//    }
//
//    public static void removeData(String city){
//        weatherDataCaсhe.remove(city);
//    }
//
//    public static void printCities(){
//        for(Map.Entry<String, WeatherData> entry : weatherDataCaсhe.entrySet()){
//            System.out.println(entry.getKey());
//        }
//    }
//
//}
//
//
