package faang.school.godbless.BJS2_23881;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        try {
            Monster monster = findNearestMonster(city, monsters);
            long distanceFromKaer = getJourneyDistance(city);
            Thread.sleep(getKillTime(distanceFromKaer, monster));
            System.out.printf("Time to get money for %s%n", monster.name());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters
                .stream()
                .min(Comparator.comparingDouble(monster -> getDistanceOfMonsterToTheCity(monster, city)))
                .orElseThrow(() -> new IllegalArgumentException("No job for Geralt"));
    }

    private static double getDistanceOfMonsterToTheCity(Monster monster, City city){
        return Math.pow(monster.location().x() - city.location().x(), 2) +
                Math.pow(monster.location().y() - city.location().y(), 2);
    }

    public long getKillTime(long journeyDistance, Monster monster) {
        System.out.printf("Geralt has started killing %s%n", monster.name());
        return journeyDistance;
    }

    public long getJourneyDistance(City dangerousCity) {
        return dangerousCity.distance();
    }
}
