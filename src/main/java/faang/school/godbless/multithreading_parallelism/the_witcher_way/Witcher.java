package faang.school.godbless.multithreading_parallelism.the_witcher_way;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int COUNT_THREAD = 4;

    public static void main(String[] args) throws InterruptedException {

        List<Monster> monsters = getMonster();
        List<City> cities = getCities();

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREAD);

        long timeStartProgramm = System.currentTimeMillis();

        for (City city: cities){
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        long timeEndProgramm = System.currentTimeMillis();
        System.out.println(timeEndProgramm - timeStartProgramm);
    }

    public static List<Monster> getMonster() {
        return List.of(new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige"));
    }

    public static List<City> getCities(){
        return List.of(new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }
}
