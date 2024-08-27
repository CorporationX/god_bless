package faang.school.godbless.BJS2_23905;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static int NUM_THREADS = 1;

    public static void main(String[] args) {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        Monster griffin = new Monster("Griffin");
        Monster basilisk = new Monster("Basilisk");
        Monster cockatrice = new Monster("Cockatrice");
        Monster chort = new Monster("Chort");
        griffin.setLocation(griffin.getLocationCoordinates("Velen"));
        basilisk.setLocation(basilisk.getLocationCoordinates("Toussaint"));
        cockatrice.setLocation(cockatrice.getLocationCoordinates("White Orcha"));
        chort.setLocation(chort.getLocationCoordinates("Skellige"));
        monsters.add(griffin);
        monsters.add(basilisk);
        monsters.add(cockatrice);
        monsters.add(chort);
        return monsters;
    }

    private static List<City> getCities() {
        return List.of(new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }
}
