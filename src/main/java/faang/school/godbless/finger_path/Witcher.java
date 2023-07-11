package faang.school.godbless.finger_path;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    @SneakyThrows
    public static void main(String[] args) {
        int NUM_THREADS = 2;
        long startTime = System.currentTimeMillis();

        List<Monster> vladMonsters = new ArrayList<>();

        vladMonsters.add(new Monster("Griffin", "Velen"));
        vladMonsters.add(new Monster("Basilisk", "Toussaint"));
        vladMonsters.add(new Monster("Cockatrice", "White Orchard"));
        vladMonsters.add(new Monster("Chort", "Skellige"));

        List<Monster> vitaliiMonsters = new ArrayList<>();

        vitaliiMonsters.add(new Monster("Vladimir", "Moscow"));
        vitaliiMonsters.add(new Monster("Ogre", "Paris"));
        vitaliiMonsters.add(new Monster("Java", "Washington"));
        vitaliiMonsters.add(new Monster("C#", "Germany"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        City amsterdam = new City("Amstedam", new Location(100, 200), 0);
        City berlin = new City("Berlin", new Location(50, 150), 100);

        CityWorker vlad = new CityWorker(amsterdam, vladMonsters);
        CityWorker vitalii = new CityWorker(berlin, vitaliiMonsters);

        List<CityWorker> workers = List.of(vlad, vitalii);

        for (var worker : workers) {
            service.execute(worker);
        }

        service.shutdown();
        service.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("Program took " + ((System.currentTimeMillis() - startTime) / 1_000) + " sec.");
    }
}