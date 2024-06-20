package faang.school.godbless.module1.sprint3.task7;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        killMonsters(getCities(),getMonsters());
    }


    private static void killMonsters(List<City> cities, List<Monster> monsters) {
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            service.submit(cityWorker);
        }
        service.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }


    public static List<Monster> getMonsters() {
        return List.of(new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige"));
    }

    private static List<City> getCities() {
        City novigrad = new City("Novigrad", new Location(0, 60), 180);
        City oxenfurt = new City("Oxenfurt", new Location(60, 0), 70);
        City vizima = new City("Vizima", new Location(120, 50), 30);
        City kaerMorhen = new City("Kaer Morhen", new Location(180, 70), 0);
        return List.of(novigrad, oxenfurt, vizima, kaerMorhen);
    }
}
