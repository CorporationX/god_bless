package faang.school.godbless.witcher;

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
        Monster NearestMonster = findNearestMonster(city, monsters);
        if (NearestMonster != null) {
            System.out.println(NearestMonster.getName() + "is the nearest monster from " + city.getName());
            System.out.println("The Witcher will arrive in the" + city.getName() + " in about " + getJourneyDistance() + " hours");
            System.out.println("Witcher is fighting with " + NearestMonster.getName());
            try {
                Thread.sleep(getKillTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        long minDistance = Long.MAX_VALUE;
        Monster NearestMonster = null;
        for (Monster monster : monsters) {
            long distance = getDistance(getCoordinates(monster.getLocation()), city.getLocation());
            if (distance < minDistance) {
                minDistance = distance;
                NearestMonster = monster;
            }
        }
        return NearestMonster;
    }

    private long getDistance(Location point1, Location point2) {
        return (long) Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }

    public long getKillTime() {
        return new Random().nextLong(5) * 1000;
    }

    public long getJourneyDistance() {

        getDistance(getCoordinates(findNearestMonster(city, monsters).getLocation()), city.getLocation());
        // это решение с учетом хождения ведьмака к монстру и обратно (за наградой).
        return city.getDistance() +
                getDistance(getCoordinates(findNearestMonster(city, monsters).getLocation()), city.getLocation()) * 2;
//        return city.getDistance();  Это решение по заданию.
    }

    public Location getCoordinates(String location) {
        if (location.equals("Velen")) {
            return new Location(0, 130);
        }
        if (location.equals("Toussaint")) {
            return new Location(50, 50);
        }
        if (location.equals("White Orchard")) {
            return new Location(100, 15);
        }
        if (location.equals("Skellige")) {
            return new Location(80, 100);
        }
        return new Location(0, 0);
    }
}
