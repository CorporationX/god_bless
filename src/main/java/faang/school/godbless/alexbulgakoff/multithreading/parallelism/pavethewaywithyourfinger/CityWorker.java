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
    private static final int EARTH_RADIUS = 6372795;
    private static final int RADIAN = 180;
    private static final Random random = new Random();
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
        return random.nextLong(250, 501);
    }

    public long getJourneyDistance(City city) {
        return city.getDistance();
    }

    private double calculateTheDistance(int pointALatitude, int pointALongitude, int pointBLatitude, int pointBLongitude) {
        //coordinates to radians

        double radianPointALatitude = pointALatitude * Math.PI / RADIAN;
        double radianPointBLatitude = pointBLatitude * Math.PI / RADIAN;
        double radianPointALongitude = pointALongitude * Math.PI / RADIAN;
        double radianPointBLongitude = pointBLongitude * Math.PI / RADIAN;

        //cos & sin latitudes & diff longitudes

        double cosRadianPointALatitude = Math.cos(radianPointALatitude);
        double cosRadianPointBLatitude = Math.cos(radianPointBLatitude);
        double sinRadianPointALatitude = Math.sin(radianPointALatitude);
        double sinRadianPointBLatitude = Math.sin(radianPointBLatitude);

        double delta = radianPointBLongitude - radianPointALongitude;

        double cosDelta = Math.cos(delta);
        double sinDelta = Math.sin(delta);

        //length big circle

        double yCircle = Math.sqrt(Math.pow(cosRadianPointBLatitude * sinDelta, 2) +
                Math.pow(cosRadianPointALatitude * sinRadianPointALatitude - sinRadianPointBLatitude * cosRadianPointBLatitude * cosDelta, 2));
        double xCircle = sinRadianPointALatitude * sinRadianPointBLatitude + cosRadianPointALatitude * cosRadianPointBLatitude * cosDelta;

        double tanDistance = Math.atan2(yCircle, xCircle);

        return  tanDistance * EARTH_RADIUS;
    }
}
