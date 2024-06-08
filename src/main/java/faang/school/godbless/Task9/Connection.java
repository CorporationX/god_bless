package faang.school.godbless.Task9;

public class Connection {

public static WeatherData connectToServer(String name) {
    System.out.println("Connecting to server to get data about this city...");
    System.out.println("Information received!");
    int temperature = (int) ( Math.random() * 35);
    int humidity = (int) ( Math.random() * 100);
    return new WeatherData(name, temperature, humidity);
}

}
