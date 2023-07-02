package faang.school.godbless.WayOfFingerCalculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", 0, Map.of("Velen", 60, "Toussaint", 80,
                "White Orchard", 150, "Skellige", 68)));
        cities.add(new City("Oxenfurt", 60, Map.of("Velen", 90, "Toussaint", 120,
                "White Orchard", 50, "Skellige", 97)));
        cities.add(new City("Vizima", 120, Map.of("Velen", 80, "Toussaint", 75,
                "White Orchard", 160, "Skellige", 25)));
        cities.add(new City("Kaer Morhen", 180, Map.of("Velen", 90, "Toussaint", 35,
                "White Orchard", 15, "Skellige", 140)));

        ExecutorService service = Executors.newFixedThreadPool(4);
        long startTime = System.currentTimeMillis();
        for (City city : cities){
            service.submit(new CityWorker(city, monsters));
        }
        service.shutdown();
        try {
            if(service.awaitTermination(2, TimeUnit.SECONDS)) {
                long endTime = System.currentTimeMillis() - startTime;
                System.out.println("Time to run a program " + endTime);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
