package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;

public class Application {

    private static final Map<String, WeatherDate> WEATHER_DATE_HASH_MAP = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("God Bless!");
        WeatherDate wd1 = new WeatherDate("Moscow", 15, 30);
        WeatherDate wd2 = new WeatherDate("Mahachkala", 24, 35);
        WeatherDate wd3 = new WeatherDate("St.Petersburg", 20, 32);

        WEATHER_DATE_HASH_MAP.put(wd1.getCity(), wd1);
        WEATHER_DATE_HASH_MAP.put(wd2.getCity(), wd2);
        WEATHER_DATE_HASH_MAP.put(wd3.getCity(), wd3);

        System.out.println(infoWeather("Moscow"));

        allMapWeatherDate();

    }

    public static WeatherDate infoWeather(String city) {
        if (WEATHER_DATE_HASH_MAP.containsKey(city)) {
            return WEATHER_DATE_HASH_MAP.get(city);
        } else {
            WEATHER_DATE_HASH_MAP.put(city, MokClass.mokMethod(city));
            return WEATHER_DATE_HASH_MAP.get(city);
        }
    }



    public static void setMapWeatherDate(String city, WeatherDate weatherDate) {
        WEATHER_DATE_HASH_MAP.put(city, weatherDate);
    }

    public static void delMapWeatherDate(String city) {
        WEATHER_DATE_HASH_MAP.remove(city);
    }

    public static void allMapWeatherDate() {
        for (Map.Entry<String, WeatherDate> pair : WEATHER_DATE_HASH_MAP.entrySet()) {
            System.out.println(pair.getKey() + pair.getValue());
        }
    }

}