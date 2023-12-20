package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 2;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockaitrice", "With Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}

@Getter
@AllArgsConstructor
class Monster {
    private String name;
    private String location;

    public Location getLocationCoordinates() {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }
}

@Getter
class City {
    private String city;
    private Location location;
    private int distance;

    public City(String city, Location location, int distance) {
        this.city = city;
        this.location = location;
        this.distance = distance;
    }
}

@Getter
class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

@Getter
@AllArgsConstructor
class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster() {
        Location cityCoordinate = city.getLocation();
        int distMax = Integer.MAX_VALUE;
        Monster monstrik = null;
        for (Monster monster : monsters) {
            Location monstrishe = monster.getLocationCoordinates();
            int distanceX = Math.abs(cityCoordinate.getX() - monstrishe.getX());
            int distanceY = Math.abs(cityCoordinate.getY() - monstrishe.getY());
            int sumDistance = distanceX + distanceY;
            if (sumDistance < distMax) {
                distMax = sumDistance;
                monstrik = monster;
            }
        }
        return monstrik;
    }

    public long getKillTime() {
        long time = new Random().nextLong(20) + 1;
        return time;
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }


    @Override
    public void run() {
        System.out.println(" Ближайший монстр к городу " + city.getCity() + " монстр " + findNearestMonster().getName());
        System.out.println(" Время на убийство: " + getKillTime());
        System.out.println(" Расстояние: " + getJourneyDistance());
    }
}