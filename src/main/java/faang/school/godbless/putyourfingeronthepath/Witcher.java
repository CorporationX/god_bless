package faang.school.godbless.putyourfingeronthepath;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime));
    }

    private static List<City> getCities() {
        return Arrays.asList(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }

    private static List<Monster> getMonsters() {
        return Arrays.asList(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }
}