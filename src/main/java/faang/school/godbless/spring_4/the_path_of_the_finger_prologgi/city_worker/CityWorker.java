package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city_worker;

import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.City;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.Location;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.monsters.Monster;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;
    private final Map<String, Supplier<Location>> locationMonster = Map.of(
            "Velen", () -> new Location(10, 20), "Toussaint", () -> new Location(40, 50),
            "White Orchard", () -> new Location(100, 10), "Skellige", () -> new Location(80, 120)
    );

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        Monster monster;
        try {
            monster = findNearestMonster(city);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Monster %s distance %s \n", monster.getName(), getJourneyDistance());
        try {
            getKillTime();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Monster findNearestMonster(City city) throws InterruptedException {

        if (!ifMonsterExists(monsters)) {
            throw new InterruptedException("empty list monsters");
        }

        int res = city.getLocation().getSumLoc();

        int coordinatesMonster = coordinatesOfTheFirstMonster();

        int distanceToMonster = Math.abs(res - coordinatesMonster);

        int distanceToMonsterNew;

        Monster monsterNew = monsters.get(0);

        for (Monster monster : monsters) {
            distanceToMonsterNew = Math.abs(res - monsterCoordinates(monster));

            if (distanceToMonsterNew < distanceToMonster) {
                distanceToMonster = distanceToMonsterNew;
                monsterNew = monster;
            }
        }

        return monsterNew;
    }

    private int monsterCoordinates(Monster monster) {
        return locationMonster.get(monster.getLocation()).get().getSumLoc();
    }

    private int coordinatesOfTheFirstMonster() {
        return locationMonster.get(monsters.get(0).getLocation()).get().getSumLoc();
    }

    private int getJourneyDistance() {
        return city.getDistanceToTheCity();
    }

    private void getKillTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    private boolean ifMonsterExists(List<Monster> monsters) {
        for (Monster monster : monsters) {
            if (locationMonster.containsKey(monster.getLocation())) {
                return true;
            }
        }
        return false;
    }
}
