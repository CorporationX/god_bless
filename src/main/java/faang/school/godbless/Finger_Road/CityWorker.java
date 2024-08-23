package faang.school.godbless.Finger_Road;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    public Monster findNearestMonster(City city, List<Monster> monsters) {
        double minDistance = Double.POSITIVE_INFINITY;
        Monster nearestMonster = null;
        for (Monster monster : monsters) {
            double dx = city.getLocation().getX() - monster.getLocation().getX();
            double dy = city.getLocation().getY() - monster.getLocation().getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            if (distance < minDistance) {
                nearestMonster = monster;
                minDistance = distance;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(Monster monster) {
        return Math.round(monster.getLocation().getY() * monster.getLocation().getX());
    }

    public long getJourneyDistance(Location pointA, Location pointB) {
        double dx = pointA.getX() - pointB.getX();
        double dy = pointA.getY() - pointB.getY();
        return Math.round(Math.sqrt(dx * dx + dy * dy));
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        if (nearestMonster != null) {
            long killTime = getKillTime(nearestMonster);
            try {
                Thread.sleep(killTime);
                System.out.println("Monster " + nearestMonster.getName() + " has been killed in city " + city.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

