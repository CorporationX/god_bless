package wayPavedFinger;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@AllArgsConstructor
public class CityWorker implements Runnable {
    final static int MAX_KILL_TIME = 5000;

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        while (!this.monsters.isEmpty()) {
            Monster nearestMonster = findNearestMonster(this.city, monsters);
            int killTime = getKillTime();
            System.out.println("В городе " + this.city.getName() + " начато убийство монстра " + nearestMonster.getName());
            try {
                Thread.sleep(killTime);
                System.out.println("В городе " + this.city.getName() + " монстр " + nearestMonster.getName() + " убит за " + killTime / 1000 + " секунд");
                this.monsters.remove(nearestMonster);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = monsters.get(0);
        double minDistance = 0;
        double distance;

        for (Monster monster : monsters) {
            distance = getJourneyDistance(city.getLocation(), getLocationCoordinates(monster.getLocation()));
            if (distance <= minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }

        return nearestMonster;
    }

    public Location getLocationCoordinates(String location) {
        switch (location) {
            case "Velen" -> {
                return new Location(10, 20);
            }
            case "Toussaint" -> {
                return new Location(40, 50);
            }
            case "White Orchard" -> {
                return new Location(100, 10);
            }
            case "Skellige" -> {
                return new Location(80, 120);
            }
            default -> {
                return new Location(0, 0);
            }
        }
    }

    public int getKillTime() {
        return new Random().nextInt(MAX_KILL_TIME);
    }

    public double getJourneyDistance(Location startLocation, Location monsterLocation) {
        int startLocationX = startLocation.getX();
        int startLocationY = startLocation.getY();

        int monsterLocationX = monsterLocation.getX();
        int monsterLocationY = monsterLocation.getY();

        return sqrt(pow((startLocationX - monsterLocationX), 2) + pow((startLocationY - monsterLocationY), 2));
    }
}
