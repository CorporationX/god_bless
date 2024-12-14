package faang.school.godbless.week1.Weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    private static Map<String, WeatherData> weatherCache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Get Weather\n2. Update Weather\n3. Remover Weather\n4. List of cities\n5. Exit");
            System.out.print("Choose an option");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getWeather(scanner);
                    break;
                case 2:
                    updateWeather(scanner);
                    break;
                case 3:
                    removeWeather(scanner);
                    break;
                case 4:
                    listCities();
                    break;
                case 5:
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private static void getWeather(Scanner scanner) {
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        WeatherData weatherData = weatherCache.get(city);
        if (weatherData != null) {
            System.out.println("Weather date fetched and cached: " + weatherData);
        }
    }

    private static void updateWeather(Scanner scanner) {
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        System.out.print("Enter temperature: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter humidity: ");
        double humidity = scanner.nextDouble();
        scanner.nextLine();

        WeatherData weatherData = new WeatherData(city, temperature, humidity);
        weatherCache.put(city, weatherData);
        System.out.println("Weather date update for city: " + city);
    }

    private static void removeWeather(Scanner scanner) {
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        WeatherData removedData = weatherCache.remove(city);
        if(removedData !=null){
            System.out.println("Weather data removed for city: "+ city);
        }else{
            System.out.println("No weather data found for city:"+city);
        }
    }

    private static void listCities(){
        if(weatherCache.isEmpty()){
            System.out.println("No weather data available. ");
        } else{
            System.out.println("Cities with cached weather data: ");
            for (String city : weatherCache.keySet()){
                System.out.println(city);
            }
        }
    }
    private static WeatherData fetchWeatherFromExternalSource(String city){
        double temperature = Math.random()*40;
        double humidity = Math.random()*100;
        return new WeatherData(city, temperature,humidity);
    }
}

