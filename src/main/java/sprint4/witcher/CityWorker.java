package sprint4.witcher;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
public class CityWorker implements Runnable {
    private static final Random RANDOM_EVENTS = new Random();
    private static final Map<String, Location> LOCATIONS = Map.of(
            "Velen", new Location(100, 10), "Toussaint", new Location(-14, 14),
            "White Orchard", new Location(-33, 25), "Skellige", new Location(40, -10)
    );
    private final City currentCity;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        int killTime = getKillTime(findCoordinatesOnMonster(nearestMonster));
        int journeyDistance = getJourneyDistance();
        System.out.printf("The nearest monster is %s. The travel time to that region will take %d. " +
                "Time to kill a monster %d\n", nearestMonster.getName(), journeyDistance, killTime);
        try {
            Thread.sleep(journeyDistance + killTime);
        } catch (InterruptedException e) {
            System.out.println("Work interrupted");
        }
        System.out.printf("%s killed\n", nearestMonster.getName());
    }

    public Monster findNearestMonster() {
        long distanceToMonster = Long.MAX_VALUE;
        Monster nearestMonster = monsters.get(0);

        for (Monster monster : monsters) {
            Location monsterLocation = findCoordinatesOnMonster(monster);
            int distance = calculateDistance(currentCity.getLocation(), monsterLocation);

            if (Math.abs(distance) < Math.abs(distanceToMonster)) {
                distanceToMonster = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public int getKillTime(Location monsterLocation) {
        return calculateDistance(currentCity.getLocation(), monsterLocation) * (RANDOM_EVENTS.nextInt(2) + 1);
    }

    public int getJourneyDistance() {
        return currentCity.getDistance() * (RANDOM_EVENTS.nextInt(4) + 1);
    }

    private Location findCoordinatesOnMonster(Monster monster) {
        if (LOCATIONS.containsKey(monster.getLocation())) {
            return LOCATIONS.get(monster.getLocation());
        }
        throw new IllegalArgumentException("The location where the monster lives does not exist");
    }

    private int calculateDistance(Location locationFrom, Location locationTo) {
        return (int) Math.sqrt(Math.pow(locationFrom.x() - locationTo.x(), 2)
                + Math.pow(locationFrom.y() - locationTo.y(), 2));
    }
}
