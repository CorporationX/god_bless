package faang.school.godbless.putyourfingeronthepath;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        long journeyDistance = getJourneyDistance();
        long killTime = getKillTime();
        try {
            System.out.printf("Geralt went to %s to kill %s\n", city.getName(), nearestMonster.getName());
            Thread.sleep(killTime);
            System.out.printf("Distance to the city %s is %s\n", city.getName(), journeyDistance);
            System.out.printf("Geralt killed %s in %s hours\n", nearestMonster.getName(), getKillTime());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    public Monster findNearestMonster() {
        double minDistance = Double.MAX_VALUE;
        Monster nearestMonster = null;
        for (Monster monster : monsters) {
            Location monsterLocation = getLocationByName(monster.getLocation());
            double distance = city.getLocation().distanceTo(monsterLocation);
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return city.getDistanceFromKaerMorhen();
    }

    private Location getLocationByName(String location) {
        return switch (location) {
            case "Velen" -> new Location(0, 50);
            case "Toussaint" -> new Location(100, 100);
            case "White Orchard" -> new Location(50, 0);
            case "Skellige" -> new Location(150, 150);
            default -> new Location(0, 0);
        };
    }
}