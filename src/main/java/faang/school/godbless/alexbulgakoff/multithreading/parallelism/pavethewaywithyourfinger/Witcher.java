package faang.school.godbless.alexbulgakoff.multithreading.parallelism.pavethewaywithyourfinger;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexander Bulgakov
 */

public class Witcher {
    private static final int NUM_THREADS = 2;
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        //Без многопоточки (кстати так быстрее ~13 миллисекунд, а при многопоточке от 700 до 800 миллисекунд)

//        Instant start = Instant.now();
//
//        for (City city : cities) {
//            CityWorker cityWorker = new CityWorker(city, monsters);
//            System.out.println(city.getName());
//            System.out.println(cityWorker.findNearestMonster(city, monsters));
//            System.out.println(cityWorker.getKillTime());
//            System.out.println(cityWorker.getJourneyDistance(city));
//        }
//
//        Instant finish = Instant.now();


        Instant start = Instant.now();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant finish = Instant.now();

        System.out.println();
        System.out.println("Program working at " + Duration.between(start, finish).toMillis() + " millis");
    }
}
