package faang.school.godbless.BJS2_18997;

public class Main {
    public static void main(String[] args) {
        WeatherStorage weatherStorage = new WeatherStorage();
        printWeatherData(weatherStorage.get("Moscow"));
        printWeatherData(weatherStorage.get("Moscow"));

        weatherStorage.update("Paris", 26, 45);
        printWeatherData(weatherStorage.get("Paris"));

        weatherStorage.update("Moscow", 22, 60);
        printWeatherData(weatherStorage.get("Moscow"));

        weatherStorage.remove("Paris");
        printWeatherData(weatherStorage.get("Paris"));

        weatherStorage.printAllCities();
    }

    private static void printWeatherData(WeatherData weatherData) {
        if (weatherData != null) {
            System.out.printf(
                    "Город: %s, Температура: %.1f, Влажность: %.1f%n",
                    weatherData.getCity(),
                    weatherData.getTemperature(),
                    weatherData.getHumidity()
            );
        } else {
            System.out.println("Информация о погоде отсутствует.");
        }
    }
}
