package faang.school.godbless.finger_way;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Witcher witcher;

    public CityWorker(City city, List<Monster> monsters, Witcher witcher) {
        this.city = city;
        this.monsters = monsters;
        this.witcher = witcher;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        int minLocation = Integer.MAX_VALUE;
        Monster outMonster = null;

        for (Monster monster : monsters) {
            int tempLocationMonster = monster.getLocation().getX() + monster.getLocation().getY();
            int locationCity = city.getLocation().getY() + city.getLocation().getX();

            if (locationCity - tempLocationMonster < minLocation) {
                minLocation = tempLocationMonster;
                outMonster = monster;
            }
        }
        return outMonster;
    }

    public long getKillTime(Monster monster) {
        return monster.getLocation().getY() + monster.getLocation().getY() + 1;
    }

    public long getJourneyDistance(Witcher witcher, City city, Monster monster) {
        return (city.getLocation().getX() + city.getLocation().getY()) -
                (witcher.getLocation().getY() + witcher.getLocation().getX()) +
                monster.getLocation().getY() + monster.getLocation().getY();
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        if (monster != null) {
            long killTime = getKillTime(monster);
            long distance = getJourneyDistance(witcher, city, monster);

            System.out.println("City: " + city.getTitle());
            System.out.println("Nearest Monster: " + monster.getName());
            System.out.println("Kill Time: " + killTime);
            System.out.println("Journey Distance: " + distance);
            System.out.println();

        }
    }
}

