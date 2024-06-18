package faang.school.godbless.BJS2_11942;

import lombok.With;

import java.util.List;

public class CityWorker implements Runnable {

    public final Witcher witcher;

    public CityWorker(Witcher witcher) {
        this.witcher = witcher;
    }

     public static long getDistanceBetween(Creature creature, City city) {
        long distance = (long) (Math.sqrt(Math.pow(city.getLocation().getXCord() - creature.getLocation().getXCord(), 2) + Math.pow(city.getLocation().getYCord() - creature.getLocation().getYCord(), 2)));

        return distance;
     }

    public static long getDistanceBetween(Creature creature1, Creature creature2) {
        long distance = (long) (Math.sqrt(Math.pow(creature1.getLocation().getXCord() - creature2.getLocation().getXCord(), 2) + Math.pow(creature1.getLocation().getYCord() - creature2.getLocation().getYCord(), 2)));

        return distance;
    }

    @Override
    public void run() {

        for (var city : witcher.getCitiesToGo()) {

            witcher.walkToCity(city);

            Monster monster = city.getNearestMonster();

            witcher.goToMonster(monster);

            witcher.killMonster(monster);
            city.getCityMonsters().remove(monster);
        }

    }
}
