package faang.school.godbless.sprint3.BJS2_6312;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        System.out.println(city.getName() + ": Monster Found: " + nearestMonster.getName());
    }

    public Monster findNearestMonster() {
        Monster nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = getNewDistance(city, Location.getLocationCoordinates(monster.getPlace()));

            if (distance < minDistance) {
                minDistance = distance;
                nearest = monster;
            }
        }

        return nearest;
    }

    private static double getNewDistance(City city, Location monsterLocation) {
        double diffX = Math.abs(city.getLocation().getX() - monsterLocation.getX());
        double diffY = Math.abs(city.getLocation().getY() - monsterLocation.getY());

        return diffX + diffY;
    }
}
