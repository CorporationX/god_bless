package faang.school.godbless.multithreading.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int THREAD_COUNT = 2;
    private static final int TERMINATION_TIME = 1;
    private static List<Monster> monsters = new ArrayList<>();
    private static List<City> cities = new ArrayList<>();

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        cities.forEach(city -> executorService.execute(new CityWorker(city, monsters)));
        executorService.shutdown();

        try {
            boolean allThreadsCompleted = executorService.awaitTermination(TERMINATION_TIME, TimeUnit.MINUTES);
            if (allThreadsCompleted) {
                System.out.println("Time of program execution: " + (System.currentTimeMillis() - startTime) + " ms");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
