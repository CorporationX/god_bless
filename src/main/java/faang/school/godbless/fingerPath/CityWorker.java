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
                if (Math.abs(monster.getLocation().getX() - city.getLocation().getX() + monster.getLocation().getY() - city.getLocation().getY())
                        < Math.abs(nearestMonster.getLocation().getX() - city.getLocation().getX() + nearestMonster.getLocation().getY() - city.getLocation().getY())) {
                    nearestMonster = monster;
                }
            }
            return nearestMonster;
        } else {
            throw new RuntimeException("Monster list must not be empty!");
        }
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
