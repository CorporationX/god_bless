package school.faang.task_48164;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int POOL_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>(List.of(
                new Monster("monster1", new Location(10, 5)),
                new Monster("monster2", new Location(1, 2)),
                new Monster("monster3", new Location(7, 3)),
                new Monster("monster4", new Location(15, 15))
        ));

        List<City> cities = new ArrayList<>(List.of(
                new City("Norilsk", new Location(7, 3)),
                new City("Moscow", new Location(10, 12)),
                new City("SP", new Location(1, 1)),
                new City("London", new Location(3, 9)),
                new City("Erevan", new Location(1, 12))
        ));

        long startTime = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < cities.size(); i++) {
            executorService.submit(new CityWorker(cities.get(i), monsters));
        }
        long endTime = System.nanoTime();
        long dur = endTime - startTime;

        if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
            System.out.println("End if threads did not end!");
            executorService.shutdown();
        }

        long startTimeNoMultithread = System.nanoTime();
        for (City city : cities) {
            new CityWorker(city, monsters).run();
        }
        long endTimeNoMultithread = System.nanoTime();
        long durNoMultithread = endTimeNoMultithread - startTimeNoMultithread;

        System.out.println("The time of program multithreading : " + dur / 1_000_000_000.0);
        System.out.println("The time of program no-multithreading : " + durNoMultithread / 1_000_000_000.0);
    }
}
