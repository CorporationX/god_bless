package faang.school.godbless.BJS2_23905;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static int NUM_THREADS = 1;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        while(!executorService.awaitTermination(3, TimeUnit.SECONDS)) {}
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }

    private static List<Monster> getMonsters() {
        return List.of(new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orcha"),
                new Monster("Chort", "Skellige"));
    }

    private static List<City> getCities() {
        return List.of(new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }
}
