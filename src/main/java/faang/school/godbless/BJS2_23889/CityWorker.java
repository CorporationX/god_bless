package faang.school.godbless.BJS2_23889;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final String INFO_ABOUT_CITY = "The city is %s %d km away \nThe nearest monster is %s \nApproximate kill time %d hours\n\n";
    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        int simulationKillTime = getKillTime(nearestMonster);
        System.out.printf(INFO_ABOUT_CITY, city.getName(), getJourneyDistance(), nearestMonster.getName(), simulationKillTime);
    }

    private Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingDouble(this::computeDistanceFromCityToMonster))
                .orElseThrow();
    }

    private int getKillTime(Monster monster) {
        return simulateKill(monster);
    }

    private int getJourneyDistance() {
        return city.getDistanceToWitcher();
    }

    private double computeDistanceFromCityToMonster(Monster monster) {
        int monsterX = monster.getLocation().getX();
        int monsterY = monster.getLocation().getY();
        int cityX = city.getLocation().getX();
        int cityY = city.getLocation().getY();
        return sqrt(pow(monsterX - cityX, 2) + pow(monsterY - cityY, 2));
    }

    private int simulateKill(Monster monster) {
        try {
            Thread.sleep(monster.getLvl() * 100L);
        } catch (InterruptedException e) {
            throw new RuntimeException("Thread Error");
        }
        return monster.getLvl();
    }
}
