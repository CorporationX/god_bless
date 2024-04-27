package faang.school.godbless.Parallelism.Witcher;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public Monster findMonster() {
        return monsters.stream()
                .filter(monster -> monster.getLocation() != null)
                .min(Comparator.comparingInt(monster ->
                        city.calculateDistanceToCity(new City(monster.getName(), monster.getLocation(), 0))
                ))
                .orElse(null);
    }

    public long getKillTime() {
        return (long) (Math.random() * 10) + 1;
    }

    public long getDistance() {
        long journeyDistance = city.getDistanceFromWitcher();
        return journeyDistance;
    }

    @Override
    public void run() {

        Monster nearestMonster = findMonster();
        System.out.println("Witcher is travels to " + city.getName() + " to kill " + nearestMonster.getName());
        long journeyTime = getDistance();
        System.out.println("Witcher goes " + journeyTime + " hours to reach " + city.getName());
        long killTime = getKillTime();
        System.out.println("If Witcher will fight with the " + nearestMonster.getName() + ". This will take " + killTime + " hours.");
    }
}

