package faang.school.godbless.witcher_map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location("Velen", 89, 341), 2));
        monsters.add(new Monster("Basilisk", new Location("Toussaint", 12, 15), 3));
        monsters.add(new Monster("Cockatrice", new Location("White Orchard", 234, -43), 3));
        monsters.add(new Monster("Chort", new Location("Skellige", 156, 123), 5));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location("Toussaint", 12, 15)));
        cities.add(new City("Oxenfurt", new Location("Skellige", 156, 123)));
        cities.add(new City("Vizima", new Location("Velen", 89, 341)));
        cities.add(new City("Kaer Morhen", new Location("White Orchard", 234, -43)));


        long threadStartTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.submit(cityWorker);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long threadEndTime = System.currentTimeMillis();

        System.out.println("Completed task using 4 threads took: " + (threadEndTime - threadStartTime));
        System.out.println();


        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executor.submit(cityWorker);
        }
        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Completed task using one thread took " + (endTime - startTime));

    }
}
