package CashCash;

import java.util.Map;



public class WheatherDate {
    private String city;
    private String temperature;
    private String humidity;

    public WheatherDate() {
    }

    public WheatherDate(String city, String temperature, String humidity) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public static void searchWeather(String city, Map<String, WheatherDate> weatherBase) {
        if (weatherBase.containsKey(city)){
            System.out.println(weatherBase.get(city));
        }
        else {
            WheatherDate.searchInfoOfWeather();
            System.out.println("Don't have information!");
        }
    }

    public static void updateWheather(String city, String temperature, String humidity, Map<String, WheatherDate> weatherBase) {
        if (!weatherBase.containsKey(city)) {
            weatherBase.put(city, new WheatherDate(city,temperature,humidity));
        }
    }

    public static void removeWheather(String city, Map<String, WheatherDate> weatherBase) {
        weatherBase.remove(city);
    }

    public static void outputWheather(Map<String, WheatherDate> weatherBase) {
        for (Map.Entry<String, WheatherDate> pair : weatherBase.entrySet()) {
            System.out.println(pair.getKey() + " : t: " + pair.getValue().temperature + " - h: " + pair.getValue().humidity);
        }
    }

    public static WheatherDate searchInfoOfWeather(){
        WheatherDate test = new WheatherDate();
        return test;
    }

    @Override
    public String toString() {
        return "WheatherDate{" +
                "city='" + city + '\'' +
                ", temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
