package faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city_worker;

import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.City;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.city.Location;
import faang.school.godbless.spring_4.the_path_of_the_finger_prologgi.monsters.Monster;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;
    private final Map<String, GetLocation> locationMonster = Map.of(
            "Velen", () -> new Location(10, 20), "Toussaint", () -> new Location(40, 50),
            "White Orchard", () -> new Location(100, 10), "Skellige", () -> new Location(80, 120)
    );

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    private static class MonsterDistance {
        protected int distanceToMonster;
        protected Monster monster;

        public MonsterDistance(int distanceToMonster, Monster monster) {
            this.distanceToMonster = distanceToMonster;
            this.monster = monster;
        }
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
        int res = city.getLocation().getSumLoc();
        int monsterSumLoc = locationMonster.get(monsters.get(0).getLocation()).getLok().getSumLoc();
        int distanceToMonster = Math.abs(res - monsterSumLoc);
        MonsterDistance distance = new MonsterDistance(distanceToMonster, monsters.get(0));
        int distanceToMonsterNew;
        if (!checkSheetMonsters(monsters)) {
            throw new InterruptedException("empty list monsters");
        }
        for (Monster monster : monsters) {
            if (locationMonster.containsKey(monster.getLocation())) {
                distanceToMonsterNew = Math.abs(res - locationMonster.get(monster.getLocation()).getLok().getSumLoc());
            } else {
                continue;
            }
            if (!(distanceToMonsterNew == 0)) {
                if (distanceToMonsterNew < distanceToMonster) {
                    distance = new MonsterDistance(distanceToMonsterNew, monster);
                    distanceToMonster = distanceToMonsterNew;
                }
            }
        }
        return distance.monster;
    }

    private int getJourneyDistance() {
        return city.getDistanceToTheCity();
    }

    private void getKillTime() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
    }

    private boolean checkSheetMonsters(List<Monster> monsters) {
        for (Monster monster : monsters) {
            if (locationMonster.containsKey(monster.getLocation())) {
                return true;
            }
        }
        return false;
    }
}
