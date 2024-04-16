package faang.school.godbless.multithreading.task_7;

import faang.school.godbless.multithreading.task_7.model.City;
import faang.school.godbless.multithreading.task_7.model.CityWorker;
import faang.school.godbless.multithreading.task_7.model.Location;
import faang.school.godbless.multithreading.task_7.model.Monster;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int POOL_SIZE = 2;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            executor.execute(new CityWorker(city, monsters));
        }
        executor.shutdown();
        long endTime = System.currentTimeMillis();
        while (!executor.awaitTermination(3, TimeUnit.SECONDS)) {}
        System.out.printf("затрачено времени на выполнение: %d%n", endTime - startTime);
    }

    private static List<Monster> getMonsters() {
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }

    private static List<City> getCities() {
        return List.of(
                new City("Novigrad", new Location(0, 60),  180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}