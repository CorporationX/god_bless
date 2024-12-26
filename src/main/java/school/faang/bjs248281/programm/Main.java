package school.faang.bjs248281.programm;

import school.faang.bjs248281.model.City;
import school.faang.bjs248281.model.Location;
import school.faang.bjs248281.model.Monster;
import school.faang.bjs248281.service.WitcherService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        long startTime = System.currentTimeMillis();
        int initialCapacityTasks = 100;
        int initialCapacityMonsters = 10;

        List<Future<?>> futures = new ArrayList<>(initialCapacityTasks);
        for (int i = 0; i < initialCapacityTasks; i++) {
            City city = new City("c" + i, new Location(Math.random() * 1000, Math.random() * 1000));
            List<Monster> monsters = new ArrayList<>(initialCapacityMonsters);
            for (int j = 0; j < initialCapacityMonsters; j++) {
                monsters.add(new Monster("m" + j, Monster.getSpawn(city.location(), 15)));
            }
            futures.add(executor.submit(new WitcherService(city, monsters)));
        }

        try {
            for (Future<?> future : futures) {
                future.get();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("------------------------------------------------");
            System.out.println("Time: " + (System.currentTimeMillis() - startTime));
            executor.shutdown();
        }
    }
}
