package school.faang.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class witcher {
    public static void main(String args[]) throws InterruptedException {
        List<City> Cities = new ArrayList<>();
        Cities.add(new City("Novigrad", new location(0, 60)));
        Cities.add(new City("Oxenfurt", new location(60, 0)));
        Cities.add(new City("Vizima", new location(120, 50)));
        Cities.add(new City("Kaer Morhen", new location(180, 70)));

        List<monster> Monsters = new ArrayList<>();
        Monsters.add(new monster("Griffin", new location(10, 15)));
        Monsters.add(new monster("Basilisk", new location(235, 121)));
        Monsters.add(new monster("Cockatrice", new location(-124, 36)));
        Monsters.add(new monster("Chort", new location(374, -237)));

        final int THREADS = 4;

        ExecutorService exec = Executors.newFixedThreadPool(THREADS);

        for (City c : Cities) {
            CityWorker worker = new CityWorker(c, Monsters);
            exec.submit(worker);
        }



        System.out.println("Все задания выполнены.");
    }
}
