package faang.school.godbless.bjs2_26016;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        System.out.println("Number of threads: " + NUM_THREADS);
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        cities.forEach(c -> executorService.submit(new CityWorker(c, monsters)));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time with threads: " + NUM_THREADS + " = " + (endTime - startTime));
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(10, 15)));
        monsters.add(new Monster("Basilisk", new Location(235, 121)));
        monsters.add(new Monster("Cockatrice", new Location(-124, 36)));
        monsters.add(new Monster("Chort", new Location(374, -237)));
        monsters.add(new Monster("Griffin Doe", new Location(11, 15)));
        monsters.add(new Monster("Basilisk Doe", new Location(236, 121)));
        monsters.add(new Monster("Cockatrice Doe", new Location(-125, 36)));
        monsters.add(new Monster("Chort Doe", new Location(375, -237)));
        monsters.add(new Monster("Griffin Smith", new Location(12, 15)));
        monsters.add(new Monster("Basilisk Smith", new Location(237, 121)));
        monsters.add(new Monster("Cockatrice Smith", new Location(-126, 36)));
        monsters.add(new Monster("Chort Smith", new Location(376, -237)));

        return monsters;
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));

        return cities;
    }
}
