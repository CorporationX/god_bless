package faang.school.godbless.BJS2_4715;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        Scanner userLocation = new Scanner(System.in);

        WeatherData moscow = new WeatherData("Moscow", 17, 51);
        WeatherData baikonur = new WeatherData("Baikonur", 22, 20);

        weatherService.getWeatherDataMap().put("Moscow", moscow);
        weatherService.getWeatherDataMap().put("Baikonur", baikonur);

        while (true) {
            String inputFromUser = userLocation.nextLine();

            if (inputFromUser.equals("Обновить")) {
                String locationForUpdate = userLocation.nextLine();
                System.out.println(weatherService.updateInformationAboutLocalWeather(locationForUpdate));
            } else if (inputFromUser.equals("Удалить")) {
                String locationForDelete = userLocation.nextLine();
                weatherService.delInformationFromDataMap(locationForDelete);
            } else if (inputFromUser.equals("Выведи")) {
                weatherService.printAllInformationAboutCitiFromDataMap();
            } else {
                WeatherData infForPrint = weatherService.getInformationAboutLocalWeather(inputFromUser);
                System.out.println(infForPrint.getCity()+ ": Температура: " + infForPrint.getTemperature() + ", Влажность: "
                        + infForPrint.getHumidity());
            }
        }
    }
}
