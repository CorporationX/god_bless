package faang.school.godbless.witcher;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);

        System.out.println("Geralt's location: " + city);
        System.out.println("Nearest Monster: " + nearestMonster);
        System.out.println("Journey distance: " + getJourneyDistance());
        System.out.println("Kill Time: " + getKillTime() + "ms");
        System.out.println(">>>>");
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
            .min(Comparator.comparingDouble(monster -> city.getLocation().calculateDistance(
                Monster.getCoordinatesBy(monster.getLocation()))
            ))
            .orElse(null);
    }

    public long getKillTime() {
        return ThreadLocalRandom.current().nextLong(1000, 3000);
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }
}
