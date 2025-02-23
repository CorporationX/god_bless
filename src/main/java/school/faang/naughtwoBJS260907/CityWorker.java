package school.faang.naughtwoBJS260907;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private List<Monster> monsters;

    private static final Location WITCHER_CASTLE = new Location(0, 0);

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            double distanceToCity = calculateDistance(WITCHER_CASTLE, city.location());
            Monster nearestMonster = findNearestMonster();
            if (nearestMonster != null) {
                System.out.printf("Nearest monster: %s%n", nearestMonster.getName());
                double distanceToMonster = calculateDistance(city.location(), nearestMonster.getLocation());
                System.out.printf("Distance from the castle to the city: %f, " +
                        "distance from the city to the nearest monster: %f.%n", distanceToCity, distanceToMonster);
            } else {
                System.out.println("There are no monsters in the list.");
                System.out.printf("Distance from the castle to the city: %f.%n", distanceToCity);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private double calculateDistance(Location loc1, Location loc2) {
        int deltaX = loc1.getIndexX() - loc2.getIndexX();
        int deltaY = loc1.getIndexY() - loc2.getIndexY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    private Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingDouble(monster ->
                        calculateDistance(city.location(), monster.getLocation())))
                .orElse(null);
    }
}
