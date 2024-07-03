package faang.school.godbless.pave_the_way_with_your_finger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<City> cities = getCities();
        List<Monster> monsters = getMonsters();
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)){}
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static List<City> getCities() {
        return List.of(new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }

    public static List<Monster> getMonsters() {
        return List.of(new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige"));
    }
}