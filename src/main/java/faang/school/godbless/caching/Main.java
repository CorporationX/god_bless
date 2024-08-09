package faang.school.godbless.caching;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, WeatherData> weatherCache = new HashMap<>();
    private static MockWeatherService weatherService = new MockWeatherService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String city;
        while (true) {
            System.out.println("\nВыберите опцию:");
            System.out.println("1. Получить информацию о погоде");
            System.out.println("2. Обновить информацию о погоде");
            System.out.println("3. Удалить информацию о погоде");
            System.out.println("4. Показать все города в кэше");
            System.out.println("5. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите название города:");
                    city = scanner.nextLine();
                    WeatherData weatherData = getWeather(city);
                    System.out.println(weatherData);
                    break;
                case 2:
                    System.out.println("Введите название города:");
                    city = scanner.nextLine();
                    updateWeather(city);
                    break;
                case 3:
                    System.out.println("Введите название города:");
                    city = scanner.nextLine();
                    removeWeather(city);
                    break;
                case 4:
                    showAllCities();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public static WeatherData getWeather(String city) {
        if (weatherCache.containsKey(city)) {
            System.out.println("Информация о погоде для города " + city + " получена из кэша.");
            return weatherCache.get(city);
        } else {
            System.out.println("Информация о погоде для города " + city
                    + " отсутствует в кэше. Запрос внешнего источника.");
            WeatherData newWeatherData = weatherService.fetchWeather(city);
            weatherCache.put(city, newWeatherData);
            return newWeatherData;
        }
    }

    public static void updateWeather(String city) {
        if (!weatherCache.containsKey(city)) {
            System.out.println("Информация о погоде для города " + city
                    + " отсутствует в кэше. Запрос внешнего источника.");
            WeatherData newWeatherData = weatherService.fetchWeather(city);
            weatherCache.put(city, newWeatherData);
            System.out.println(newWeatherData);
        } else {
            System.out.println("Обновление информации о погоде для города " + city + ".");
            WeatherData newWeatherData = weatherService.fetchWeather(city);
            weatherCache.put(city, newWeatherData);
            System.out.println("Информация о погоде обновлена: " + newWeatherData);
        }
    }

    public static void removeWeather(String city) {
        if (weatherCache.containsKey(city)) {
            weatherCache.remove(city);
            System.out.println("Информация о погоде для города " + city + " удалена из кэша.");
        } else {
            System.out.println("Информация о погоде для города " + city + " отсутствует в кэше.");
        }
    }

    public static void showAllCities() {
        if (weatherCache.isEmpty()) {
            System.out.println("В кэше нет информации о погоде.");
        } else {
            System.out.println("Города в кэше:");
            for (String city : weatherCache.keySet()) {
                System.out.println(city);
            }
        }
    }
}
