package faang.school.godbless.BJS2_8914;

import java.util.HashMap;

public class CheckValidation {
    public void checkInputCity(String city) {
        if (city.isEmpty() || city.trim().isEmpty())
            throwIllegalArgument("Город не может быть пустым");
    }

    public boolean checkCityExistInWeatherList(String city, HashMap<String, WeatherData> weatherDataMap) {
        if (!weatherDataMap.containsKey(city))
            throwIllegalArgument("Такого города нет в списке");
        return true;
    }

    public void checkTemperatureAndHumidity(double temperature, int humidity) {
        if (temperature < 40 || temperature > 40 ||
                humidity < 0 || humidity > 100)
            throwIllegalArgument("Неверные данные");
    }

    private void throwIllegalArgument(String error) {
        throw new IllegalArgumentException(error);
    }
}
