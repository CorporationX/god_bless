package faang.school.godbless.task.fingerPath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final List<Monster> monsters = new ArrayList<>();
    private static final List<City> cities = new ArrayList<>();

    static {
        monsters.add(new Monster("Griffin", new Location(10, 10)));
        monsters.add(new Monster("Basilisk", new Location(30, 25)));
        monsters.add(new Monster("Cockatrice", new Location(20, 30)));
        monsters.add(new Monster("Chort", new Location(40, 50)));

        City novigrad = new City("Novigrad", new Location(20, 50), 500);
        City oxenfurt = new City("Oxenfurt", new Location(30, 30), 400);
        City vizima = new City("Vizima", new Location(10, 20), 520);
        City kaerMorhen = new City("Kaer Morhen", new Location(120, 80), 0);

        cities.addAll(List.of(novigrad, oxenfurt, vizima, kaerMorhen));
    }

    public static void cityNearestMonster(int threadCount) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();

        if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
            System.out.println("The nearest monsters were found and killed");
        }
    }

    public static void main(String[] args) {
        try {
            long startTime = System.currentTimeMillis();
            cityNearestMonster(4);
            long endTime = System.currentTimeMillis();
            System.out.println("Elapsed time: " + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            cityNearestMonster(1);
            endTime = System.currentTimeMillis();
            System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
