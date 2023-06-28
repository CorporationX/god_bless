package faang.school.godbless.sprint4.witcher.classes;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private List<City> cities;
    private List<Monster> monsters;

    @Override
    public void run() {
        for (City city : cities) {
            while (monsters.size() != 0) {
                Monster monster = findNearestMonster(city, monsters);
                System.out.println("Fight with  " + monster.getName() + " is starting...");
                try {
                    Thread.sleep(getKillTime(monster));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(monster.getName() + " is dead!");
                monsters.remove(monster);
            }
            System.out.println("Geralt go to journey");
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        double distance = -1;
        Monster nearestMonster = null;
        Location cityLocation = city.getLocation();
        for (Monster monster : monsters) {
            double monsterDistance = Location.getDistance(monster.getLocation(), cityLocation);
            if (distance < monsterDistance) {
                distance = monsterDistance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(Monster monster) {
//        return new Random().nextLong(1_000, 15_000);
        return 1_000;
    }

    public static double getJourneyDistance(City firstCity, City secondCity) {
        return Location.getDistance(firstCity.getLocation(), secondCity.getLocation());
    }
}
