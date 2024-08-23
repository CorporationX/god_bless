package faang.school.godbless.finger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private final static Integer NUM_THREADS = 1;
    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(10, 20)));
        monsters.add(new Monster("Basilisk", new Location(100, 200)));
        monsters.add(new Monster("Cockatrice", new Location(150, 20)));
        monsters.add(new Monster("Chort", new Location(20, 100)));



        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180, 10));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70, 12));
        cities.add(new City("Vizima", new Location(120, 50), 30, 109));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0, 1));

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        long start = (new Date()).getTime();
        for (var city : cities) {
            service.submit(new CityWorker(city, monsters));
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }


        long end = (new Date()).getTime();
        System.out.println("\n\nвремя обработки всех городов: " + (end - start) + " millis");
    }
}

//с 4 потоками время выполнения ~11s, с 1 потоком ~41s