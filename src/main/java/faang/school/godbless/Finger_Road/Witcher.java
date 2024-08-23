package faang.school.godbless.Finger_Road;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location("Mountain", 0, 60)));
        monsters.add(new Monster("Basilisk", new Location("Forest", 50, 20)));
        monsters.add(new Monster("Cockatrice", new Location("White Orchard", 60, 20)));
        monsters.add(new Monster("Chort", new Location("Castle", 30, 28)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        ExecutorService executor = Executors.newFixedThreadPool(5); //один поток - 807 милисекунд, 5 потоков - 822 милисекунды
        for(City city : cities) {
            CityWorker cityWorker = new CityWorker(city,monsters);
            executor.execute(cityWorker);
        }
        executor.shutdown();
        try{ if(!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executor.shutdownNow(); } }
        catch (InterruptedException e) {
            executor.shutdownNow();
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Время выполнения: " + executionTime);
    }
}
