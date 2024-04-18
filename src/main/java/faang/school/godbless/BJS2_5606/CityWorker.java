package faang.school.godbless.BJS2_5606;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private City heraldCity;
    private final Random RANDOM = new Random();

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster(city, monsters);
        System.out.println("К городу: " + city.getName() + " ближайший монстр: " + nearestMonster.getName());

        getKillTime();

        long distance = getJourneyDistance();
        if (distance == 0) {
            System.out.println("Геральд находиться в " + heraldCity.getName());
        } else {
            System.out.println(city.getName() + " находиться в " + distance + " км от Геральда");
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        long distanceVector = Integer.MAX_VALUE;
        Monster returnMonster = null;

        for (Monster monster : monsters) {
            long vectorDistance = getVectorDistance(city.getLocation(), monster.getLocation());
            if (distanceVector > vectorDistance) {
                distanceVector = vectorDistance;
                returnMonster = monster;
            }
        }
        return returnMonster;
    }

    public void getKillTime() {
        final int MAX_TIME = 5;
        final int MIN_TIME = 1;

        long waitTime = RANDOM.nextLong(MAX_TIME) + MIN_TIME;
        System.out.println("Подождите " + waitTime + " усл. единицы времени пока Геральд убивает монстра");

        try {
            Thread.sleep(waitTime * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public long getJourneyDistance() {
        if (city.getName().equals(heraldCity.getName())) {
            return 0L;
        } else {
            return getVectorDistance(city.getLocation(), heraldCity.getLocation());
        }
    }

    private long getVectorDistance(Location location1, Location location2) {
        long distanceVector;

        long coordinateX = location2.getX() - location1.getX();
        long coordinateY = location2.getY() - location1.getY();

        distanceVector = (long) Math.abs(Math.sqrt((Math.pow(coordinateX, 2) + (Math.pow(coordinateY, 2)))));

        return distanceVector;
    }
}
