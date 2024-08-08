package faang.school.godbless;

public class Application {
    public static void main(String[] args) {
        Main weatherMain = new Main();

        weatherMain
                .getWeatherData("New York")
                .thenAccept(weatherData -> System.out.println("Weather data for New York: " + weatherData))
                .thenCompose(v -> weatherMain.getWeatherData("New York"))
                .thenAccept(weatherData -> System.out.println("Weather data for New York: " + weatherData))
                .thenRun(() -> {
                    System.out.println("Listing all cities in the cache:");
                    for (String city : weatherMain.allCities()) {
                        System.out.println(city);
                    }
               });

        weatherMain
                .getWeatherData("London")
                .thenAccept(weatherData -> System.out.println("Weather data for New York: " + weatherData))
                .thenCompose(v -> weatherMain.getWeatherData("London"))
                .thenAccept(weatherData -> System.out.println("Weather data for New York: " + weatherData))
                .thenRun(() -> {
                    System.out.println("Listing all cities in the cache:");
                    for (String city : weatherMain.allCities()) {
                        System.out.println(city);
                    }
                });
    }
}