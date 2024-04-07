package faang.school.godbless.BJS2_4715;

import java.util.Map;
import java.util.Random;

public class ActionOnWeather {
    public static WeatherData getInformationAboutLocalWeather(String location,
                                                              Map<String, WeatherData> weatherDataMap) {
        WeatherData informationAboutLocalWeather = new WeatherData();

        if (weatherDataMap.containsKey(location)){
            informationAboutLocalWeather.setCity(weatherDataMap.get(location).getCity());
            informationAboutLocalWeather.setTemperature(weatherDataMap.get(location).getTemperature());
            informationAboutLocalWeather.setHumidity(weatherDataMap.get(location).getHumidity());
        } else {
            informationAboutLocalWeather = getInformationFromService(location, weatherDataMap);
        }
        return informationAboutLocalWeather;
    }

    public static WeatherData getInformationFromService(String location, Map<String, WeatherData> weatherDataMap) {
        Random randomInf = new Random();
        WeatherData infAboutLocalWeather = new WeatherData(location,
                randomInf.nextInt(35 - (-45) + 1) + (-45), randomInf.nextInt(90 + 1));

        weatherDataMap.put(infAboutLocalWeather.getCity(), infAboutLocalWeather);

        return infAboutLocalWeather;
    }

    public static void delInformationFromDataMap(String locationForDelete, Map<String, WeatherData> weatherDataMap) {
        weatherDataMap.remove(locationForDelete);
    }

    public static void printAllInformationAboutCitiFromDataMap(Map<String, WeatherData> weatherDataMap){
        for (Map.Entry<String, WeatherData> entry : weatherDataMap.entrySet()){
            System.out.println("Город: " + entry.getKey() + ", Температура: " + entry.getValue().getTemperature() +
                    ", Влажность: " + entry.getValue().getHumidity());
        }
    }
}
