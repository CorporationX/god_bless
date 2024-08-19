package faang.school.godbless.BJS2_23881;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(0, 45)));
        monsters.add(new Monster("Basilisk", new Location(55, 2)));
        monsters.add(new Monster("Cockatrice", new Location(134, 78)));
        monsters.add(new Monster("Chort", new Location(170, 63)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));


        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();
        cities.forEach(city -> executorService.execute(new CityWorker(city, monsters)));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.currentTimeMillis();

        System.out.printf("%s threads saved cities by: %s", NUM_THREADS, (endTime-startTime));
    }
}
