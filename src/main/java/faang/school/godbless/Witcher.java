package faang.school.godbless;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();

        ExecutorService executor = Executors.newFixedThreadPool(1);

        long start = System.currentTimeMillis();
        for (City city: cities){
            executor.submit(new CityWorker(city, monsters));
        }
        executor.shutdown();
        while(!executor.awaitTermination(3, TimeUnit.SECONDS)){}
        long end = System.currentTimeMillis();

        System.out.println("Program completed in: " + (end - start) + " milliseconds");
    }

    public static List<Monster> getMonsters(){
        return List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );
    }

    public static List<City> getCities(){
        return List.of(
                new City("Novigrad", new Location(0, 60),  180),
                new City("Oxenfurt", new Location(60, 0), 70),
                new City("Vizima", new Location(120, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );
    }
}
