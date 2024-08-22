package faang.school.godbless.witcher.services;

import faang.school.godbless.witcher.models.City;
import faang.school.godbless.witcher.models.Monster;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        try {
            Monster nearestMonster = findNearestMonster(city, monsters);
            System.out.println("Founded nearest monster " + nearestMonster);
            System.out.println("Going to " + nearestMonster.getLocation());
            Thread.sleep(getJourneyDistance(nearestMonster));
            System.out.println("Fighting with monster " + nearestMonster.getName());
            Thread.sleep(getKillTime(nearestMonster));
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException " + ie.getMessage());
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.parallelStream()
                .min(Comparator.comparingDouble(this::getAbsDistance))
                .orElseThrow(() -> new IllegalArgumentException("Not founded nearest monster"));
    }

    public long getKillTime(Monster monster) {
        return monster.getFightTime();
    }

    public long getJourneyDistance(Monster monster) {
        return (long) (city.getDistanceToHero() + getAbsDistance(monster));
    }

    private double getAbsDistance(Monster monster) {
        return Math.abs(city.getLocation().getX() - monster.getLocation().getX()
                + city.getLocation().getY() - monster.getLocation().getY());
    }
}
