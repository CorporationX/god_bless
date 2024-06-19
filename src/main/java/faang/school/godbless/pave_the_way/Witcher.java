package faang.school.godbless.pave_the_way;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(20, 40)));
        monsters.add(new Monster("Basilisk", new Location(55, 25)));
        monsters.add(new Monster("Cockatrice", new Location(120, 150)));
        monsters.add(new Monster("Chort", new Location(100, 100)));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        long endTime = System.currentTimeMillis();

        System.out.println("Total time: " + (endTime - startTime) + " ms");
    }
}
