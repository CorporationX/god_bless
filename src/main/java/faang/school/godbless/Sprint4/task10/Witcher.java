package faang.school.godbless.Sprint4.task10;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 5;

    private static City novigrad = new City("Novigrad", new Location(0, 60), 180);
    private static City oxenfurt = new City("Oxenfurt", new Location(60, 0), 70);
    private static City vizima = new City("Vizima", new Location(120, 50), 30);
    private static City kaerMorhen = new City("Kaer Morhen", new Location(180, 70), 0);


    public static void main(String[] args) {

        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();


        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();

        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige"));
    }

    private static List<City> getCities() {
        return List.of(novigrad, oxenfurt, vizima, kaerMorhen);
    }
}
