package faang.school.godbless.vedmak_and_monsters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static faang.school.godbless.vedmak_and_monsters.TimeUtils.secondElapsedTime;

public class Witcher {

    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.nanoTime();

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", 0, 60, 120, 180));
        cities.add(new City("Oxenfurt", 60, 0, 50, 70));
        cities.add(new City("Vizima", 120, 50, 0, 30));
        cities.add(new City("Kaer Morhen", 180, 70, 30, 0));

        int NUM_THREADS = 5;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            executor.execute(new CityWorker(monsters, city));
        }

        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.MILLISECONDS);

        long endTime = System.nanoTime();

        double total = secondElapsedTime(startTime, endTime);
        System.out.println("Total application running time: " + total + " seconds");
    }
}