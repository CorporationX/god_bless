package faang.school.godbless.BJS2_23922;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {

        Location witcherCity = new Location(0, 0);
        double distance = witcherCity.distanceTo(city.getLocation());
        double nearestDistance = Double.MAX_VALUE;
        Monster nearestMonster = null;

        for (Monster monster : monsters) {
            double monsterDistance = city.getLocation().distanceTo(monster.getLocation());
            if (monsterDistance < nearestDistance) {
                nearestDistance = monsterDistance;
                nearestMonster = monster;
            }
        }
        if (nearestMonster != null) {
            double totalDistance = distance + nearestDistance;
            System.out.println("Need to kill " + nearestMonster.getName());
            System.out.println("Distance to the target " + totalDistance);
        }
    }
}
