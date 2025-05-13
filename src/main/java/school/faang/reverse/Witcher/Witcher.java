package school.faang.reverse.Witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Велен", new Location(2, 3)));
        cities.add(new City("каэр Морхен", new Location(5, 7)));
        cities.add(new City("Скеллеге", new Location(6, 1)));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Стрыга", new Location(3, 4)));
        monsters.add(new Monster("Вампир", new Location(4, 6)));
        monsters.add(new Monster("Туманник", new Location(1, 1)));

        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            worker.run();
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Single-threaded execution time: %.4f seconds%n", (endTime - startTime) / 1000.0);

        startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            System.out.println(" ");
        }
        endTime = System.currentTimeMillis();
        System.out.printf("Multi-threaded execution time: %.4f seconds%n", (endTime - startTime) / 1000.0);
    }
}