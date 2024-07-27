package faang.school.godbless.path;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private final City city;
    private final List<Monster> monsters;
    public void run() {
        System.out.println("Nearest monster to city " + city.getName() + " is " + findNearestMonster(city, monsters).getName());
        System.out.println("Time to kill: " + getKillTime());
        System.out.println("Distance to city: " + getJourneyDistance());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        double minDistance = Double.MAX_VALUE;

        for (Monster monster : monsters) {
            double distance = city.getLocation().distanceTo(monster.getLocationCoordinates(monster.getLocation()));

            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 10);
    }

    public long getJourneyDistance() {
        return 1L;
    }

}
