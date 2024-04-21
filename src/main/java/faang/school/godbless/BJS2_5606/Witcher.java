package faang.school.godbless.BJS2_5606;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        Random random = new Random();
        final int NUM_THREADS = 4;
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(25, 154)));
        monsters.add(new Monster("Basilisk", new Location(163, 38)));
        monsters.add(new Monster("Cockatrice", new Location(29, 28)));
        monsters.add(new Monster("Chort", new Location(61, 7)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));


        String position = "Kaer";
        City heraldCity = cities.stream().filter(city -> city.getName().equals(position)).findFirst().orElse(null);

        if (heraldCity == null) {
            heraldCity = new City(position, new Location(random.nextInt(200) + 1, random.nextInt(200) + 1));
            cities.add(heraldCity);
        }

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();

        for (City city : cities) {
            Runnable worker = new CityWorker(city, monsters, heraldCity);
            executor.execute(worker);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не все задачи завершились за отведенное время");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
