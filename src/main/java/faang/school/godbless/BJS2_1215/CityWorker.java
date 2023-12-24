package faang.school.godbless.BJS2_1215;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Nearest monster is " + findNearestMonster().getName());
        System.out.println("Time to kill is " + getKillTime());
        System.out.println("Journey distance is " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Location cityLocation = city.getLocation();

        return monsters.stream()
                .min(Comparator.comparingDouble(monster -> Additional.calculateDistance(monster.getLocation(), cityLocation)))
                .orElseThrow();
    }

    public double getKillTime() {
        return city.getName().length() * (Math.random() + 1) * 100;
    }

    public double getJourneyDistance() {
        return city.getDistance();
    }
}