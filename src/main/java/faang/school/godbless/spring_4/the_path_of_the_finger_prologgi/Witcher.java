package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi;

import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.City;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.Location;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city_worker.CityWorker;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.monsters.Monster;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {

        List<Monster> monsterList = List.of(
                new Monster("Griffin", "Velen"),
                new Monster("Basilisk", "Toussaint"),
                new Monster("Cockatrice", "White Orchard"),
                new Monster("Chort", "Skellige")
        );

        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60), 180),
                new City("Oxenfurt", new Location(60, 50), 70),
                new City("Vizima", new Location(90, 50), 30),
                new City("Kaer Morhen", new Location(180, 70), 0)
        );

        int NUM_THREADS = 4;
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        cities.forEach(city1 -> pool.execute(new CityWorker(city1, monsterList)));
        pool.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime));
    }
}
