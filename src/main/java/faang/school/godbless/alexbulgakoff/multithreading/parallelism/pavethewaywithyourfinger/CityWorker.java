package faang.school.godbless.alexbulgakoff.multithreading.parallelism.pavethewaywithyourfinger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Random;

/**
 * @author Alexander Bulgakov
 */
@AllArgsConstructor
@Getter
@ToString
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        long killTime = getKillTime();

        System.out.println("Nearest monster to " + city.getName() + " " + monster.getName());

        System.out.println("Kill time for " + monster.getName() + " " + killTime + " millis");
        try {
            Thread.sleep(killTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Distance to city: " + getJourneyDistance(city) + " km");
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        double largestDistance = Double.MAX_VALUE;
        double nearestDistance;
        Monster nearestMonster = null;

        for (Monster monster : monsters) {
            nearestDistance = calculateTheDistance(monster.getMonsterCoordinate().getX(), monster.getMonsterCoordinate().getY(),
                    city.getLocation().getX(), city.getLocation().getY());
            if (nearestDistance < largestDistance) {
                largestDistance = nearestDistance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        Random random = new Random();
        return random.nextLong(250, 501);
    }

    public long getJourneyDistance(City city) {
        return city.getDistance();
    }

    private double calculateTheDistance(int firstLatitude, int firstLongitude, int secondLatitude, int secondLongitude) {
        final int EARTH_RADIUS = 6372795;

        //coordinates to radians

        double radianFirstLatitude = firstLatitude * Math.PI / 180;
        double radianSecondLatitude = secondLatitude * Math.PI / 180;
        double radianFirstLongitude = firstLongitude * Math.PI / 180;
        double radianSecondLongitude = secondLongitude * Math.PI / 180;

        //cos & sin latitudes & diff longitudes

        double cosRadianFirstLatitude = Math.cos(radianFirstLatitude);
        double cosRadianSecondLatitude = Math.cos(radianSecondLatitude);
        double sinRadianFirstLatitude = Math.sin(radianFirstLatitude);
        double sinRadianSecondLatitude = Math.sin(radianSecondLatitude);

        double delta = radianSecondLongitude - radianFirstLongitude;

        double cosDelta = Math.cos(delta);
        double sinDelta = Math.sin(delta);

        //length big circle

        double yCircle = Math.sqrt(Math.pow(cosRadianSecondLatitude * sinDelta, 2) +
                Math.pow(cosRadianFirstLatitude * sinRadianFirstLatitude - sinRadianSecondLatitude * cosRadianSecondLatitude * cosDelta, 2));
        double xCircle = sinRadianFirstLatitude * sinRadianSecondLatitude + cosRadianFirstLatitude * cosRadianSecondLatitude * cosDelta;

        double tanDistance = Math.atan2(yCircle, xCircle);

        return  tanDistance * EARTH_RADIUS;
    }
}
