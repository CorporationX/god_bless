package faang.school.godbless.BJS2_23917;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static final int NUM_THREADS = 4;
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Pair(7, 5), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Basilisk", new Pair(7, 4), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Cockatrice", new Pair(7, 2), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Chort", new Pair(10, 3), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Griffin", new Pair(7, 5), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Basilisk", new Pair(7, 4), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Cockatrice", new Pair(7, 2), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Chort", new Pair(10, 3), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Griffin", new Pair(7, 5), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Basilisk", new Pair(7, 4), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Cockatrice", new Pair(7, 2), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Chort", new Pair(10, 3), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Griffin", new Pair(7, 5), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Basilisk", new Pair(7, 4), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Cockatrice", new Pair(7, 2), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Chort", new Pair(10, 3), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Griffin", new Pair(7, 5), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Basilisk", new Pair(7, 4), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Cockatrice", new Pair(7, 2), new Random().nextInt(5, 15)));
        monsters.add(new Monster("Chort", new Pair(10, 3), new Random().nextInt(5, 15)));



        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Pair(2, 5)));
        cities.add(new City("Oxenfurt", new Pair(1, 3)));
        cities.add(new City("Vizima", new Pair(2, 3)));
        cities.add(new City("Kaer Morhen", new Pair(10, 4)));
        cities.add(new City("Novigrad", new Pair(2, 5)));
        cities.add(new City("Oxenfurt", new Pair(1, 3)));
        cities.add(new City("Vizima", new Pair(2, 3)));
        cities.add(new City("Kaer Morhen", new Pair(10, 4)));
        cities.add(new City("Novigrad", new Pair(2, 5)));
        cities.add(new City("Oxenfurt", new Pair(1, 3)));
        cities.add(new City("Vizima", new Pair(2, 3)));
        cities.add(new City("Kaer Morhen", new Pair(10, 4)));
        cities.add(new City("Novigrad", new Pair(2, 5)));
        cities.add(new City("Oxenfurt", new Pair(1, 3)));
        cities.add(new City("Vizima", new Pair(2, 3)));
        cities.add(new City("Kaer Morhen", new Pair(10, 4)));
        cities.add(new City("Novigrad", new Pair(2, 5)));
        cities.add(new City("Oxenfurt", new Pair(1, 3)));
        cities.add(new City("Vizima", new Pair(2, 3)));
        cities.add(new City("Kaer Morhen", new Pair(10, 4)));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.nanoTime();

        for(var city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        long totalTime = endTime - startTime;

        System.out.println("Total time: " + totalTime / 1000000 + " milliseconds");
    }
}
