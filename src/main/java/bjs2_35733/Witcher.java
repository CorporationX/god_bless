package bjs2_35733;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) throws InterruptedException {
        List<City> cities = List.of(
                new City("Moscow", new Location(13, 10)),
                new City("Prague", new Location(8, 16)),
                new City("New-York", new Location(5, 5))
        );

        List<Monster> monsters = List.of(
                new Monster("Ghost", new Location(15, 10)),
                new Monster("Witch", new Location(15, 10)),
                new Monster("Slime", new Location(15, 10))
        );

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        cities.forEach(city -> executorService.submit(new CityWorker(city, monsters)));
        executorService.shutdown();

        if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Time limit reached. Forcing shutdown");
            executorService.shutdownNow();
        }
    }
}
