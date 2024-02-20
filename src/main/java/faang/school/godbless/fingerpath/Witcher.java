package faang.school.godbless.fingerpath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(String.format("Program active time: %d ms", totalTime));
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            cities.add(new City("Novigrad", new Location(0, 60), 180));
            cities.add(new City("Oxenfurt", new Location(60, 0), 70));
            cities.add(new City("Vizima", new Location(120, 50), 30));
            cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        }
        return cities;
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            monsters.add(new Monster("Griffin", "Velen"));
            monsters.add(new Monster("Basilisk", "Toussaint"));
            monsters.add(new Monster("Cockatrice", "White Orchard"));
            monsters.add(new Monster("Chort", "Skellige"));
        }
        return monsters;
    }
}
