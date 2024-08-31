package witcher;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@ToString
public class Witcher {
    private int power = 250;
    private int health = 1000;

    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(40,7) ,"Velen"));
        monsters.add(new Monster("Basilisk", new Location(23,87), "Toussaint"));
        monsters.add(new Monster("Cockatrice", new Location(28,73), "White Orchard"));
        monsters.add(new Monster("Chort", new Location(58,47), "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long startTime = System.currentTimeMillis();

//        for (City city : cities) {
//            executorService.execute(new CityWorker(city, monsters));
//        }

        for (City city : cities) {
        CityWorker cityWorker = new CityWorker(city, monsters);
        System.out.println("Ближайший монстр к городу " + city.getName() + " это " + cityWorker.findNearestMonster().getName());
        System.out.println("Время для убийства этого монстра " + cityWorker.getKillTime());
        System.out.println("Дистанция до города " + cityWorker.getJourneyDistance());
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
