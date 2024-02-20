package faang.school.godbless.fingerpath;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    private static final int NUM_THREADS = 4;
    public static Location heraldLocation = new Location( 180, 89);
    public static void main(String[] args) {


        List<Monster> monsters = new ArrayList<>();
        List<Location> locations = createCoordinates();

        monsters.add(new Monster("Griffin", locations.get(0)));
        monsters.add(new Monster("Basilisk", locations.get(1)));
        monsters.add(new Monster("Cockatrice", locations.get(2)));
        monsters.add(new Monster("Chort", locations.get(3)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", locations.get(5)));
        cities.add(new City("Oxenfurt", locations.get(6)));
        cities.add(new City("Vizima", locations.get(7)));
        cities.add(new City("Kaer Morhen", heraldLocation));
        cities.add(new City("Novigrad", locations.get(5)));
        cities.add(new City("Oxenfurt", locations.get(6)));
        cities.add(new City("Vizima", locations.get(7)));
        cities.add(new City("Kaer Morhen", heraldLocation));
        cities.add(new City("Novigrad", locations.get(5)));
        cities.add(new City("Oxenfurt", locations.get(6)));
        cities.add(new City("Vizima", locations.get(7)));
        cities.add(new City("Kaer Morhen", heraldLocation));
        cities.add(new City("Novigrad", locations.get(5)));
        cities.add(new City("Oxenfurt", locations.get(6)));
        cities.add(new City("Vizima", locations.get(7)));
        cities.add(new City("Kaer Morhen", heraldLocation));

        long start = System.currentTimeMillis();
        ExecutorService executors = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities){
            executors.submit(new CityWorker(city, monsters));
        }

        executors.shutdown();
        while(!executors.isTerminated()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Finished " + (end - start));
    }

    public static List<Location> createCoordinates(){
        List<Location> createdLocations = new ArrayList<>();

        // Generate and add 10 random Location objects to the list
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100); // Random x-coordinate between 0 and 99
            int y = random.nextInt(100); // Random y-coordinate between 0 and 99
            createdLocations.add(new Location(x, y));
        }
        return createdLocations;
    }
}
