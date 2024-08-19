package faang.school.godbless.BJS2_23886;

import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }
    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " started work");
        Monster monster = findNearestMonster(city, monsters);
        System.out.printf("Nearest monster for city %s: %s%n", city.getName(), monster.getName());
        System.out.println("Time to kill " + monster.getName() + " = " + getKillTime() + " min.");
        System.out.println("Total journey distance = " + getJourneyDistance(city, monster));
        System.out.println("Thread " + Thread.currentThread().getId() + " finished work");
    }

    private Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .sorted((monster1, monster2) -> {
                    Double distance1 = distanceBetweenTwoLocations(city.getLocation(), monster1.getLocation());
                    Double distance2 = distanceBetweenTwoLocations(city.getLocation(), monster2.getLocation());
                    return distance2.compareTo(distance1);
                })
                .limit(1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("List of monsters is empty"));
    }

    private long getKillTime() {
        return (new Random().nextLong(6) + 5);
    }

    private double getJourneyDistance(City city, Monster monster) {
        return (double) city.getDistance() + distanceBetweenTwoLocations(city.getLocation(), monster.getLocation());
    }

    private double distanceBetweenTwoLocations(Location location1, Location location2) {
        return Math.sqrt(Math.pow((location1.getX() - location2.getX()), 2) + Math.pow(location1.getY() - location2.getY(), 2));
    }
}
