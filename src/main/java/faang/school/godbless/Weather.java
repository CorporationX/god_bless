package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//В классе Main, создайте HashMap с ключом типа String (название города) и значением типа WeatherData (объект класса WeatherData).
//
//Реализуйте метод, который будет принимать название города и возвращать информацию о погоде в этом городе.
// Если информация о погоде для данного города присутствует в кэше (HashMap), верните эту информацию.
// В противном случае, имитируйте запрос к внешнему источнику (например, вызовите метод, который "получает" информацию о погоде),
// сохраните полученную информацию в кэше и верните её. Внешний сервис — просто мок-класс с пустым методом-заглушкой.
//
//Реализуйте методы для следующих действий: обновление информации о погоде в кэше для определённого города;
// удаление информации о погоде из кэша по названию города; вывод списка всех городов, для которых доступна информация о погоде в кэше.
public class Weather {
    public static Map<String,WeatherData> weatherMap = new HashMap<>();
    public static WeatherData findWeather (String city) {
        if(weatherMap.containsKey(city)) {
            return weatherMap.get(city);
        } else {
            return getWeatherExternal(city);
        }
    }
    public static WeatherData getWeatherExternal (String city) {
        //that is mock
        return new WeatherData(city,45, 78);
    }
    public static void addWeatherIntoCache (String city, WeatherData data) {
        weatherMap.put(city,data);
    }
    public static void removeWeatherFromCache (String city) {
        weatherMap.remove(city);
    }
    public static List<String> citiesWithCachedWeather () {
        List<String> cities = new ArrayList<>();
        for (Map.Entry<String,WeatherData> entry : weatherMap.entrySet()) {
            cities.add(entry.getKey());
        }
        return cities;
    }
}
