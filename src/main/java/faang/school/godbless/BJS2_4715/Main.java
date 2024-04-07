package faang.school.godbless.BJS2_4715;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, WeatherData> weatherDataMap = new HashMap<>();
        Scanner userLocation = new Scanner(System.in);

        WeatherData moscow = new WeatherData("Moscow", 17, 51);
        WeatherData baikonur = new WeatherData("Baikonur", 22, 20);

        weatherDataMap.put("Moscow", moscow);
        weatherDataMap.put("Baikonur", baikonur);

        while (true) {
            String inputFromUser = userLocation.nextLine();

            if (inputFromUser.equals("Обновить")) {
                String locationForUpdate = userLocation.nextLine();
                ActionOnWeather.getInformationFromService(locationForUpdate, weatherDataMap);
            } else if (inputFromUser.equals("Удалить")) {
                String locationForDelete = userLocation.nextLine();
                ActionOnWeather.delInformationFromDataMap(locationForDelete, weatherDataMap);
            } else if (inputFromUser.equals("Выведи")) {
                ActionOnWeather.printAllInformationAboutCitiFromDataMap(weatherDataMap);
            } else {
                WeatherData infForPrint = ActionOnWeather.getInformationAboutLocalWeather(inputFromUser, weatherDataMap);
                System.out.println(infForPrint.getCity()+ ": Температура: " + infForPrint.getTemperature() + ", Влажность: "
                        + infForPrint.getHumidity());
            }
        }
    }
}
