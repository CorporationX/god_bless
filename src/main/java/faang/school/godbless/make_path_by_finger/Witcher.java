package faang.school.godbless.make_path_by_finger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;
    private static final int TIME_OUT = 60;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService witcher = Executors.newFixedThreadPool(NUM_THREADS);

        List<City> cities = getCities();
        List<Monster> monsters = getMonsters();

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            witcher.execute(new CityWorker(city, monsters));
        }

        witcher.shutdown();
        witcher.awaitTermination(TIME_OUT, TimeUnit.SECONDS);

        long endTime = System.currentTimeMillis();
        System.out.println("Total amount of time: " + (endTime - startTime));
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", new Location(0, 50)),
                new Monster("Basilisk", new Location(80, 0)),
                new Monster("Cockatrice", new Location(150, 50)),
                new Monster("Chort", new Location(170, 65))
        );
    }

    private static List<City> getCities() {
        return List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}
