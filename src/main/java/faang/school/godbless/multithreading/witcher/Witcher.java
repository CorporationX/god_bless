package faang.school.godbless.multithreading.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Witcher {

    private static final int NUM_THREADS = 1;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        var threadPool = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            threadPool.execute(new CityWorker(city, monsters));
        }

        threadPool.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + " ms.");
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));
        return monsters;
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        return cities;
    }
}
