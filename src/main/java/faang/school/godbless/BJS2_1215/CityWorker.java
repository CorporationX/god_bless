package faang.school.godbless.BJS2_1215;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private City witcherCity;
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
                .min(Comparator.comparingDouble(monster -> calculateDistance(monster.getLocation(), cityLocation)))
                .orElseThrow();
    }

    public double getKillTime() {
        return city.getName().length() * (Math.random() + 1) * 100;
    }

    public double getJourneyDistance() {
        return calculateDistance(city.getLocation(), witcherCity.getLocation());
    }

    private static double calculateDistance(Location location1, Location location2) {
        double x1 = location1.getX();
        double y1 = location1.getY();
        double x2 = location2.getX();
        double y2 = location2.getY();
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}