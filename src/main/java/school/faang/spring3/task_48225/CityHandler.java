package school.faang.spring3.task_48225;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class CityHandler implements Callable<Double> {
    private static final Location WITCHER = new Location(0, 0);
    private City city;
    private List<Monster> monsters;

    private double getDistance(Location p1, Location p2) {
        return Math.sqrt((p1.getCoordinateX() - p2.getCoordinateX()) * (p1.getCoordinateX() - p2.getCoordinateX())
                + (p1.getCoordinateY() - p2.getCoordinateY()) * (p1.getCoordinateY() - p2.getCoordinateY()));
    }

    @Override
    public Double call() throws Exception {
        double cityDistance = getDistance(WITCHER, city.getLocation());
        Monster closestMonster = null;
        double minDistance = Double.MAX_VALUE;
        for (Monster monster : monsters) {
            double monsterDistance = getDistance(city.getLocation(), monster.getLocation());
            if (monsterDistance < minDistance) {
                minDistance = monsterDistance;
                closestMonster = monster;
            }
        }
        if (closestMonster != null) {
            System.out.println("Monster near city: " + city.getName() + " - " + closestMonster.getName());
            System.out.println("Distance to the monster: " + (cityDistance + minDistance));
        } else {
            System.out.println("Unable to find nearest path to the monster");
        }
        return minDistance + cityDistance;
    }
}
