package faang.school.godbless.witcher_map;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        List<Monster> monsters = getMonsterList();
        List<City> cities = getCityList();

        long start = System.currentTimeMillis();

        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time spent: " + (end - start));
    }

    private static List<City> getCityList(){
        return List.of(
                new City("Novigrad", new Location(0, 60),  180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0));
    }

    private static List<Monster> getMonsterList(){
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort","Skellige"));
    }
}
