package faang.school.godbless.BJS2_23922;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(10, 15)));
        monsters.add(new Monster("Basilisk", new Location(235, 121)));
        monsters.add(new Monster("Cockatrice", new Location(-124, 36)));
        monsters.add(new Monster("Chort", new Location(374, -237)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));

        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (City city : cities){
            executor.submit(new CityWorker(city, monsters));
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Общее время выполнения: " + duration + " мс");
    }
}
