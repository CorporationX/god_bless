package faang.school.godbless.multithreadingS4.layPathWithYourFinger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int COUNT_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();

        List<City> cities = getCites();

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

        long startTime = System.currentTimeMillis();

        cities.forEach(city -> executorService.execute(new CityWorker(city, monsters)));

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.printf("%n\tExecution time: %d ms",  executionTime);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }

    private static List<City> getCites() {
        return List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}
