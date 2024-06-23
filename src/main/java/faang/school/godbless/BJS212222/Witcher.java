package faang.school.godbless.BJS212222;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private final static int NUM_THREADS = 5;
    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Kaer Morhen", new Location(0, 0)),
                new City("Novigrad", new Location(8, 8)),
                new City("Oxenfurt", new Location(12, 12)),
                new City("Vizima", new Location(22, 22))
        );

        List<Monster> monsters = List.of(
                new Monster("Ghoul", new Location(0, 5)),
                new Monster("Vampire", new Location(5, 10)),
                new Monster("Kikimora", new Location(10, 15)),
                new Monster("Striga", new Location(15, 20))
        );

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();
        cities.forEach(city -> {
            CityWorker cityWorker = new CityWorker(cities.get(0), city, monsters);
            service.execute(cityWorker);
        });

        service.shutdown();
        try {
            if (!service.awaitTermination(20, TimeUnit.SECONDS)) {
                List<Runnable> unfinishedTasks = service.shutdownNow();
                unfinishedTasks.forEach(System.out::println);
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted: " + e.getMessage());
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("All tasks finished. And it takes " + (endTime - startTime) + " ms");
        }
    }
}
