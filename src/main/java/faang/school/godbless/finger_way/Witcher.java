package faang.school.godbless.finger_way;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Setter
@Getter
public class Witcher {
    private String name;
    private Location location;

    public Witcher(Location location) {
        this.location = location;
        this.name = "Geralt";
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen", new Location(0, 20)));
        monsters.add(new Monster("Basilisk", "Toussaint", new Location(35, 20)));
        monsters.add(new Monster("Cockatrice", "White Orchard", new  Location(15, 20)));
        monsters.add(new Monster("Chort", "Skellige", new Location(80, 100)));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  new Location(90, 70)));
        cities.add(new City("Oxenfurt", new Location(60, 0), new Location(35, 35)));
        cities.add(new City("Vizima", new Location(120, 50), new Location(15, 20)));
        cities.add(new City("Kaer Morhen", new Location(180, 70), new Location(0, 0)));

        Witcher witcher = new Witcher(new Location(0, 0));


        final int NUM_THREADS = 4;
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters, witcher);
            poolThreads.execute(cityWorker);
        }

        poolThreads.shutdown();

        try {
            poolThreads.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");

    }
}
