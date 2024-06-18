package faang.school.godbless.PaveTheWayWithYourFinger;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class CityWorker implements Runnable {
    private final City city;
    private final Location currentWitcherLocation;
    private final List<Area> areas;
    private final List<Monster> monsters;
    private final Map<Monster, Location> monsterAndCoordinate = new HashMap<>();
    private final Map<Monster, Integer> monsterAndToCityDistance = new HashMap<>();

    @Override
    public void run() {
        long startTime = System.nanoTime();

        matchingMonsterAndCoordinate(monsters, areas);
        Monster nearestMonster = findNearestMonster();
        long journeyDistance = getJourneyDistance(nearestMonster);
        long timeToKillNearestMonster = getKillTime(journeyDistance);

        long endTime = System.nanoTime();;
        long t = endTime - startTime;

        System.out.println(city.getName() +
                ": nearest monster " + nearestMonster.getName() +
                ", time to kill " + timeToKillNearestMonster +
                ", journey distance " + journeyDistance +
                " " + t);
    }

    public Monster findNearestMonster() {
        Map<Integer, Monster> toCityDistanceAndMonsters = new HashMap<>();
        for (Monster monster : monsters) {
            monsterAndToCityDistance.put(monster, calculateDistanceTo(monsterAndCoordinate.get(monster)));
        }
        monsterAndToCityDistance.keySet()
                .forEach((monster) -> toCityDistanceAndMonsters.put(monsterAndToCityDistance.get(monster), monster));
        return toCityDistanceAndMonsters.get(monsterAndToCityDistance.values().stream()
                .mapToInt(Integer::intValue).min().orElse(0));
    }

    private int calculateDistanceTo(Location location) {
        return (int) sqrt(pow(city.getLocation().x() - location.x(), 2) + pow(city.getLocation().y() - location.y(), 2));
    }

    private void matchingMonsterAndCoordinate(List<Monster> monsters, List<Area> areas) {
        for (Monster monster : monsters) {
            for (Area area : areas) {
                if (Objects.equals(monster.getLocation(), area.getName())) {
                    monsterAndCoordinate.put(monster, area.getLocation());
                }
            }
        }
    }

    public long getKillTime(long journeyDistance) {
        return (long) (journeyDistance * 10 + Math.random() * 100);
    }

    public long getJourneyDistance(Monster monster) {
        return calculateDistanceTo(currentWitcherLocation) + calculateDistanceTo(monsterAndCoordinate.get(monster));
    }

    public CityWorker(City city, List<Monster> monsters, List<Area> areas, Location currentWitcherLocation) {
        this.city = city;
        this.monsters = monsters;
        this.areas = areas;
        this.currentWitcherLocation = currentWitcherLocation;
    }
}
