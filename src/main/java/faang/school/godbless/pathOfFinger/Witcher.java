package faang.school.godbless.pathOfFinger;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
        LocalDateTime time1 = LocalDateTime.now();
        System.out.println("Время начала выполнения программы " + time1 + "\n");
        for (var city : cities){
            service.submit(new CityWorker(city, monsters));
        }
        service.shutdown();
        try {
            if(service.awaitTermination(2, TimeUnit.SECONDS)) {
                LocalDateTime time2 = LocalDateTime.now();
                System.out.println("\n" + "Время окончания выполнения программы " + time2);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
