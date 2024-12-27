package faang.school.godbless.sprint_3.task_48271;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultithreadedWitcherMode {

    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<City> cities = new ArrayList<>();
        cities.add(new City("Bremervoord", new Location(48, 103)));
        cities.add(new City("Claremont", new Location(102, 97)));
        cities.add(new City("Hengfors", new Location(159, 234)));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Kikimora", new Location(12, 67)));
        monsters.add(new Monster("Leshen", new Location(45, 143)));
        monsters.add(new Monster("Chort", new Location(52, 96)));
        monsters.add(new Monster("Bruxa", new Location(3, 75)));
        monsters.add(new Monster("Basilisks", new Location(165, 88)));
        monsters.add(new Monster("Djinn", new Location(97, 305)));

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                long endTime   = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println("Total program execution time: " + totalTime);
            }
        } catch (InterruptedException e) {
            System.out.println("An exception occurred!" + e);
        }
    }
}
