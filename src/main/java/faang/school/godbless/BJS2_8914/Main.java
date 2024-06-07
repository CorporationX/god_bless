package faang.school.godbless.BJS2_8914;

/*



Реализуйте методы для следующих действий:

вывод списка всех городов, для которых доступна информация о погоде в кэше.
 */


import java.util.HashMap;

public class Main {
    public CheckValidation checkValidation = new CheckValidation();
    private HashMap<String, WeatherData> weatherDataMap = new HashMap<>();
    private Mock mock = new Mock();

    public WeatherData getWeatherInCity(String city) {
        checkValidation.checkInputCity(city);

        if (!checkValidation.checkCityExistInWeatherList(city, weatherDataMap)) {
            weatherDataMap.put(city, mock.getWeatherInCity(city));
        }

        return weatherDataMap.get(city);
    }


    public void updateWeatherInfo(String city, double temperature, int humidity) {
        checkValidation.checkInputCity(city);
        checkValidation.checkCityExistInWeatherList(city, weatherDataMap);
        checkValidation.checkTemperatureAndHumidity(temperature, humidity);

        weatherDataMap.put(city, new WeatherData(city, temperature, humidity));
    }

    public void deleteWeatherInfoByCity(String city) {
        checkValidation.checkInputCity(city);
        checkValidation.checkCityExistInWeatherList(city, weatherDataMap);

        weatherDataMap.remove(city);
    }

    public void findAllCity() {
        weatherDataMap.forEach((k, v) -> System.out.println(v));
    }
}
