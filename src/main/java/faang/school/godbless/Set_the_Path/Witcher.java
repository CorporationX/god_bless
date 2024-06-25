package faang.school.godbless.Set_the_Path;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final List<Monster> MONSTERS = new ArrayList<>();
    private static final List<City> CITIES = new ArrayList<>();
    private static final int NUM_THREADS = 1;
    private static final City NOVIGRAD = new City("Novigrad", new Location(0, 60),  180);
    private static final City OXENFURT = new City("Oxenfurt", new Location(60, 0), 70);
    private static final City VIZIMA = new City("Vizima", new Location(120, 50), 30);
    private static final City KAER = new City("Kaer Morhen", new Location(180, 150), 0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long start = System.currentTimeMillis();
        for (City city : CITIES) {
            executorService.submit(new CityWorker(city, MONSTERS));
        }
        executorService.shutdown();
        while(!executorService.awaitTermination(3, TimeUnit.SECONDS)) {}
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    static {

        MONSTERS.add(new Monster("Griffin", Monster.getCoordinates("Velen")));
        MONSTERS.add(new Monster("Basilisk", Monster.getCoordinates("Toussaint")));
        MONSTERS.add(new Monster("Cockatrice", Monster.getCoordinates("White Orchard")));
        MONSTERS.add(new Monster("Chort", Monster.getCoordinates("Skellige")));

        CITIES.add(NOVIGRAD);
        CITIES.add(OXENFURT);
        CITIES.add(VIZIMA);
        CITIES.add(KAER);

    }

}
