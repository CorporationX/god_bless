package faang.school.godbless.BJS2_11988;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Witcher {
    private Location location;
    private City city;

    public Witcher(City city) {
        this.city = city;
        this.location = city.getLocation();
    }

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(15, 45)));
        monsters.add(new Monster("Basilisk", new Location(100, 25)));
        monsters.add(new Monster("Cockatrice", new Location(150, 30)));
        monsters.add(new Monster("Chort", new Location(72, 15)));
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        ExecutorService service = Executors.newFixedThreadPool(4);
        long startTime = System.currentTimeMillis();
        for (City c : cities) {
            CityWorker worker = new CityWorker(cities, new Witcher(new City("Kaer Morhen", new Location(180, 70), 0)));
            service.submit(() -> {
                worker.addMonsters(monsters);
                worker.goToCity(c);
                worker.run();
                System.out.println("After all, Withcer went to " + c.getName());
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(25, TimeUnit.SECONDS);
            long endTime = System.currentTimeMillis();
            long workTime = endTime - startTime;
            System.out.println("Program finished for " + workTime);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
