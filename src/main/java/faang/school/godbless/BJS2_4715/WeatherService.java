package faang.school.godbless.BJS2_4715;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
public class WeatherService {
    private Map<String, WeatherData> weatherDataMap = new HashMap<>();
    private Random randomInf = new Random();

    public WeatherData getInformationAboutLocalWeather(String location) {
        if (!weatherDataMap.containsKey(location)){
            weatherDataMap.put(location, getInformationFromService(location));
        }
        return weatherDataMap.get(location);
    }

    public WeatherData getInformationFromService(String location) {
        final int MAX_TEMPERATURE = 35;
        final int MIN_TEMPERATURE = -45;
        final int MAX_HUMIDITY = 90;

        WeatherData infAboutLocalWeather = new WeatherData(location,
                randomInf.nextInt(MAX_TEMPERATURE - MIN_TEMPERATURE + 1) + MIN_TEMPERATURE,
                randomInf.nextInt(MAX_HUMIDITY + 1));

        return infAboutLocalWeather;
    }

    public void delInformationFromDataMap(String locationForDelete) {
        weatherDataMap.remove(locationForDelete);
    }

    public String updateInformationAboutLocalWeather(String location){
        weatherDataMap.put(location, getInformationFromService(location));

        return location + ": Температура: " + weatherDataMap.get(location).getTemperature() + ", Влажность: " +
                weatherDataMap.get(location).getHumidity();
    }

    public void printAllInformationAboutCitiFromDataMap(){
        for (Map.Entry<String, WeatherData> entry : weatherDataMap.entrySet()){
            System.out.println("Город: " + entry.getKey() + ", Температура: " + entry.getValue().getTemperature() +
                    ", Влажность: " + entry.getValue().getHumidity());
        }
    }
}
