package faang.school.godbless.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    static final int NUM_THREADS = 2;

    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time of execution: " + (endTime - startTime));
    }
}
