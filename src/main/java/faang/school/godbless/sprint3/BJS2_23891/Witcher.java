package faang.school.godbless.sprint3.BJS2_23891;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
public class Witcher {
    public static List<Monster> monsters = new ArrayList<>();
    public static List<City> cities = new ArrayList<>();
    public static void main(String[] args) {
        monsters.add(new Monster("Griffin", new Location(10, 32)));
        monsters.add(new Monster("Basilisk", new Location(100, 0)));
        monsters.add(new Monster("Cockatrice", new Location(47, 28)));
        monsters.add(new Monster("Chort", new Location(180, 50)));

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.submit(cityWorker);
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                long endTime = System.currentTimeMillis();
                System.out.println("Time spent: " + (endTime - startTime) + "ms");
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
