package faang.school.godbless.BJS2_23902;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int NUM_THREADS = 6;

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

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

        cities.forEach(city -> executorService.execute(new CityWorker(city, monsters)));
        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Witcher finished!");
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        long end = System.currentTimeMillis();
        System.out.println("Witcher took " + (end - start) + "ms");
    }
}
