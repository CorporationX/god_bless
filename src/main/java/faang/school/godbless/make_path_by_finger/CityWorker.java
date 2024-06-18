package faang.school.godbless.make_path_by_finger;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster monsterToKill = findNearestMonster(city, monsters);

        System.out.println("Nearest monster to city " + city + " is " + monsterToKill);
        System.out.println("Time needed to kill monster: " + getKillTime(monsterToKill));
        System.out.println("Journey distance is: " + getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        if (monsters == null) {
            throw new IllegalArgumentException("Seems like The Witcher has lost the map");
        }

        if (monsters.isEmpty()) {
            throw new IllegalArgumentException("The Witcher has killed all the monsters");
        }

        return monsters.stream()
                .min((monsterFirst, monsterSecond) -> compareMonstersByDistance(city, monsterFirst, monsterSecond)).get();
    }

    public long getKillTime(Monster monster) {
        long startTime = System.currentTimeMillis();

        try {
            Thread.sleep(monster.getName().length() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong during the battle between monster and the witcher");
        }

        return System.currentTimeMillis() - startTime;
    }

    public long getJourneyDistance() {
        return city.getDistanceToWitcher();
    }

    private int compareMonstersByDistance(City city, Monster monsterFirst, Monster monsterSecond) {
        return (int) (calculateDistance(city, monsterFirst) - calculateDistance(city, monsterSecond));
    }

    private double calculateDistance(City city, Monster monster) {
        Location cityLocation = city.getLocation();
        Location monsterLocation = monster.getLocation();
        double distanceInSquare =
                Math.pow(cityLocation.x() - monsterLocation.x(), 2) + Math.pow(cityLocation.y() - monsterLocation.y(), 2);
        return Math.sqrt(distanceInSquare);
    }
}
