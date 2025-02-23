package school.faang.naughtwoBJS260907;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    public static void main(String[] args) {
        List<CityWorker> cityWorkers = cityWorkerList();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (CityWorker cityWorker : cityWorkers) {
            executor.submit(cityWorker);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        log.debug("Program is completed");
    }

    private static List<CityWorker> cityWorkerList() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Drowners", new Location(4, 5)));
        monsters.add(new Monster("Ghouls", new Location(7, 2)));
        monsters.add(new Monster("Alghouls", new Location(3, 1)));
        monsters.add(new Monster("Werewolves", new Location(6, 8)));
        monsters.add(new Monster("Wraiths", new Location(5, 3)));
        monsters.add(new Monster("Sirens", new Location(2, 6)));
        monsters.add(new Monster("Chorts", new Location(1, 4)));
        monsters.add(new Monster("Revenants", new Location(8, 7)));
        monsters.add(new Monster("Neckers", new Location(3, 9)));
        monsters.add(new Monster("Bandits", new Location(0, 0)));
        monsters.add(new Monster("Harpies", new Location(10, 4)));
        monsters.add(new Monster("Skeletal Warriors", new Location(4, 6)));
        monsters.add(new Monster("Gargoyles", new Location(7, 3)));
        monsters.add(new Monster("Dopplers", new Location(3, 0)));
        monsters.add(new Monster("Basilisks", new Location(6, 9)));
        monsters.add(new Monster("Leshens", new Location(5, 4)));
        monsters.add(new Monster("Griffins", new Location(2, 7)));
        monsters.add(new Monster("Crones", new Location(1, 5)));
        monsters.add(new Monster("Fiends", new Location(8, 8)));
        monsters.add(new Monster("Chimeras", new Location(3, 2)));
        monsters.add(new Monster("Wild Hunt", new Location(0, 1)));
        monsters.add(new Monster("Siren Queens", new Location(10, 5)));
        monsters.add(new Monster("Strigas", new Location(9, 1)));
        monsters.add(new Monster("Cursed Ones", new Location(4, 2)));
        monsters.add(new Monster("Kikimores", new Location(3, 4)));
        monsters.add(new Monster("Vampires", new Location(7, 7)));
        monsters.add(new Monster("Elementals", new Location(5, 1)));
        monsters.add(new Monster("Fleders", new Location(2, 8)));
        monsters.add(new Monster("Wyverns", new Location(1, 3)));
        monsters.add(new Monster("Cave Trolls", new Location(8, 2)));
        monsters.add(new Monster("Flamethrowers", new Location(3, 5)));
        monsters.add(new Monster("Grave Hags", new Location(0, 3)));
        monsters.add(new Monster("Banshees", new Location(10, 6)));
        monsters.add(new Monster("Shadows", new Location(4, 9)));
        monsters.add(new Monster("Golems", new Location(6, 3)));
        monsters.add(new Monster("Leshen Guardians", new Location(7, 8)));
        monsters.add(new Monster("Drowner Mages", new Location(2, 1)));
        monsters.add(new Monster("Rock Trolls", new Location(5, 7)));
        monsters.add(new Monster("Manticore", new Location(9, 9)));
        monsters.add(new Monster("Roc", new Location(8, 4)));
        monsters.add(new Monster("Specters", new Location(1, 0)));
        monsters.add(new Monster("Elders", new Location(3, 8)));
        monsters.add(new Monster("Nightwraiths", new Location(2, 4)));
        monsters.add(new Monster("Echinops", new Location(0, 7)));

        List<CityWorker> cityWorkers = new ArrayList<>();
        cityWorkers.add(new CityWorker(new City("Novigrad", new Location(5, 4)), monsters));
        cityWorkers.add(new CityWorker(new City("Oxenfurt", new Location(-5, 4)), monsters));
        cityWorkers.add(new CityWorker(new City("Kaer Morhen", new Location(3, -2)), monsters));
        cityWorkers.add(new CityWorker(new City("Vengerberg", new Location(2, 7)), monsters));
        cityWorkers.add(new CityWorker(new City("Toussaint", new Location(6, 3)), monsters));
        cityWorkers.add(new CityWorker(new City("Skellige", new Location(1, 5)), monsters));
        cityWorkers.add(new CityWorker(new City("Wyzima", new Location(0, 2)), monsters));
        cityWorkers.add(new CityWorker(new City("Belhaven", new Location(-2, 6)), monsters));
        cityWorkers.add(new CityWorker(new City("Lindenvale", new Location(4, -1)), monsters));
        cityWorkers.add(new CityWorker(new City("Rivia", new Location(-3, 3)), monsters));
        cityWorkers.add(new CityWorker(new City("Gedyneith", new Location(4, 5)), monsters));
        cityWorkers.add(new CityWorker(new City("Lazarett", new Location(1, 2)), monsters));
        cityWorkers.add(new CityWorker(new City("Velen", new Location(-1, 1)), monsters));
        cityWorkers.add(new CityWorker(new City("Crow's Perch", new Location(2, 3)), monsters));
        cityWorkers.add(new CityWorker(new City("Kovir", new Location(6, -2)), monsters));
        cityWorkers.add(new CityWorker(new City("Lursten", new Location(0, 0)), monsters));
        cityWorkers.add(new CityWorker(new City("Cintra", new Location(-5, -3)), monsters));
        cityWorkers.add(new CityWorker(new City("Rinde", new Location(3, 6)), monsters));

        return cityWorkers;
    }
}
