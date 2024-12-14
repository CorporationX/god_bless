package school.faang.task_44860;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>(List.of("Moscow", "Warsaw", "London"));

        FrequentUpdateWeatherCache frequentUpdate = new FrequentUpdateWeatherCache();
        cities.forEach((city) -> System.out.println(frequentUpdate.getWeatherData(city)));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------".repeat(30));
        cities.forEach((city) -> System.out.println(frequentUpdate.getWeatherData(city)));

        System.out.println("--------".repeat(30));

        StandardWeatherCache standardUpdate = new StandardWeatherCache();
        cities.forEach((city) -> System.out.println(standardUpdate.getWeatherData(city)));
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------".repeat(30));
        cities.forEach((city) -> System.out.println(standardUpdate.getWeatherData(city)));
    }
}
