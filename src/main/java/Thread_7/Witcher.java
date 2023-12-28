package Thread_7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(70, 60)));
        monsters.add(new Monster("Basilisk", new Location(120, 60)));
        monsters.add(new Monster("Cockatrice", new Location(0, 80)));
        monsters.add(new Monster("Chort", new Location(80, 80)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        long startProgramm = System.currentTimeMillis();

        for (City city : cities) {
            executor.submit(new CityWorker(city, monsters));
        }

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Calculating don't complete");
        }
        executor.isShutdown();

        System.out.println("Calculating complete by " + (System.currentTimeMillis() - startProgramm) + " mills");

    }
}
