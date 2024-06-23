package faang.school.godbless.paveTheWay;

import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        double minDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = calculateDistance(city.getLocation(), monster.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (long) (Math.random() * 5000) + 1000;
    }

    public long getJourneyDistance() {
        return (long) calculateDistance(new Location(0, 0), city.getLocation());
    }

    private double calculateDistance(Location loc1, Location loc2) {
        double dx = loc1.getX() - loc2.getX();
        double dy = loc1.getY() - loc2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        long journeyDistance = getJourneyDistance();
        long killTime = getKillTime();

        System.out.println("Геральт путешествует до " + city.getName() + ", чтобы убить " + nearestMonster.getName() + ".");
        try {
            Thread.sleep(journeyDistance);
            System.out.println("Геральт прибыл в " + city.getName() + ". Начинает убивать " + nearestMonster.getName() + ".");
            Thread.sleep(killTime);
            System.out.println(nearestMonster.getName() + " в " + city.getName() + " убит.");
        } catch (InterruptedException e) {
            System.err.println("Задача была прервана.");
        }
    }
}