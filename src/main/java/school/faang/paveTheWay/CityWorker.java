package school.faang.paveTheWay;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Location castle = new Location(0, 0);
        double cityDistance = calculateDistance(castle, city.getLocation());
        Monster minMonster = monsters.stream()
                .min(Comparator.comparingDouble(
                        monster -> calculateDistance(city.getLocation(), monster.getLocation())))
                .orElseThrow(() -> new IllegalArgumentException("The list is empty"));
        double minMonsterDistance = calculateDistance(city.getLocation(), minMonster.getLocation());

        System.out.println("The distance from the castle to the destination city: " + cityDistance);
        System.out.println("The distance from the castle to the nearest monster: " + minMonsterDistance);
    }

    private double calculateDistance(Location location1, Location location2) {
        int deltaX = location1.getX() - location2.getX();
        int deltaY = location1.getY() - location2.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
