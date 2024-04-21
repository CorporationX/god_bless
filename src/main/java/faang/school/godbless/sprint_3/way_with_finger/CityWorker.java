package faang.school.godbless.sprint_3.way_with_finger;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {
    private static final Format FORMATTER = new DecimalFormat("#.##");
    private City city;
    private List<Monster> monsters;

    public CityWorker(List<Monster> monsters, City city) {
        this.monsters = monsters;
        this.city = city;
    }

    @Override
    public void run() {
        double distance = getJourneyDistance();
        try {
            Thread.sleep(getKillTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("Монстер %s был убит около %s.\n", findNearestMonster().getName(), city.getName());
        System.out.printf("Было пройдено %s.\n", FORMATTER.format(distance).replace(",", "."));
    }

    public Monster findNearestMonster() {
        Monster nearestMonster = null;
        double distance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double currentDistance = getDistance(city.getLocation(), monster.getLocation());
            if (currentDistance < distance) {
                distance = currentDistance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    private double getDistance(Location location1, Location location2) {
        return Math.sqrt(
                Math.pow(location2.getX() - location1.getX(), 2) + Math.pow(location2.getY() - location1.getY(), 2)
        );
    }

    public int getKillTime() {
        return new Random().nextInt(5000);
    }

    public double getJourneyDistance() {
        return city.getDistanceFromGerald() + getDistance(city.getLocation(), findNearestMonster().getLocation());
    }
}