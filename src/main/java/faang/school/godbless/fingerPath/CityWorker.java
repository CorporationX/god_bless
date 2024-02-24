package faang.school.godbless.fingerPath;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters != null && !monsters.isEmpty()) {
            Monster nearestMonster = monsters.get(0);
            for (Monster monster : monsters) {
                if (getDistanceBetween(monster.getLocation(), city.getLocation())
                        < getDistanceBetween(nearestMonster.getLocation(), city.getLocation())) {
                    nearestMonster = monster;
                }
            }
            return nearestMonster;
        } else {
            throw new RuntimeException("Monster list must not be empty!");
        }
    }

    public int getDistanceBetween(Location location1, Location location2) {
        return Math.abs(location1.getX() - location2.getX() + location1.getY() - location2.getY());
    }

    public long getKillTime() {
        Random random = new Random();
        return random.nextLong(30);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }

    @Override
    public void run() {
        System.out.printf("%s nearest monster is %s", city.getCityName(), findNearestMonster(city, monsters).getName());
        System.out.println();
        System.out.printf("Distance to Witcher is %d", getJourneyDistance());
        System.out.println();
        System.out.printf("Killtime is %d", getKillTime());
        System.out.println();
    }
}
