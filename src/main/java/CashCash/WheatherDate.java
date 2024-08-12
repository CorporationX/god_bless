package CashCash;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.Random;

@AllArgsConstructor
public class WheatherDate {
    private String city;
    private int temperature;
    private int  humidity;

    public WheatherDate() {
    }

    public static void searchWeather(String city, Map<String, WheatherDate> weatherBase) {
        if (weatherBase.containsKey(city)){
            System.out.println(weatherBase.get(city));
        }
        else {
            WheatherDate.searchInfoOfWeather();
            Random rand = new Random();
            int temp = rand.nextInt(0,20);

            int hum = rand.nextInt(50,90);
            weatherBase.put(city, new WheatherDate(city, temp, hum));
            System.out.println(weatherBase.get(city));
        }
    }

    public static void updateWheather(String city, int temperature, int humidity, Map<String, WheatherDate> weatherBase) {
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
