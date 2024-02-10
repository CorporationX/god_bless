package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class WeatherData {
    private String city;
    private double temperature;
    private double humidity;

    public WeatherData(String city, double temperature, double humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    private static Map<String, WeatherData> weatherMap = new HashMap<>();

    public String toString(){
        return temperature + "°C " + humidity;
    }

    public static void main(String args[]){
        WeatherData weatherInfo1 = info("Moscow");
        System.out.println("Температура в Москве: " + weatherInfo1.getTemperature() + "°C");

        updateInfo("Moscow", 28.0, 55.0);

        WeatherData weatherInfo2 = info("Moscow");
        System.out.println("Обновленная температура в Москве: " + weatherInfo2.getTemperature() + "°C");

        removeInfo("Moscow");

        printAll();
    }

    public static WeatherData info(String city) {
        if (weatherMap.containsKey(city)) {
            System.out.println("Информация о погоде для города " + city + " найдена в кэше.");
            return weatherMap.get(city);
        } else {
            System.out.println("Информации о погоде для города " + city + " нет в кэше. Выставляем стандартные настройки..");
            WeatherData newWeatherData = nothing(city);
            weatherMap.put(city, newWeatherData);
            return newWeatherData;
        }
    }

    private static WeatherData nothing(String city) {
        return new WeatherData(city, 0, 0);
    }

    public static void updateInfo(String city, double temperature, double humidity) {
        WeatherData newWeatherData = new WeatherData(city, temperature, humidity);
        weatherMap.put(city, newWeatherData);
        System.out.println("Информация о городе " + city + " обновлена");
    }

    public static void removeInfo(String city){
        if(weatherMap.containsKey(city)){
            WeatherData deletedWeatherData = new WeatherData(city, 0.0, 0.0);
            weatherMap.put(city, deletedWeatherData);
            System.out.println("Информация из города " + city + " удалена");
        } else System.out.println("Информация не найдена");

    }

    public static void printAll(){
        for(Map.Entry<String, WeatherData> entry : weatherMap.entrySet()){
            System.out.println("Город " + entry.getKey() + "; Информация: " + entry.getValue());
        }
    }
}
