package faang.school.godbless.BJS223887;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Nearest monster to city " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("Time to kill it: " + getKillTime());
        System.out.println("Distance to the city - " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingDouble(monster -> distanceTo(monster.getLocationCoordinates())))
                .orElse(null);
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return (long) city.getDistance();
    }

    private double distanceTo(Location monsterLocation) {
        return Math.sqrt(
                Math.pow(monsterLocation.getX() - city.getLocation().getX(), 2)
                        + Math.pow(monsterLocation.getY() - city.getLocation().getY(), 2)
        );
    }
}
