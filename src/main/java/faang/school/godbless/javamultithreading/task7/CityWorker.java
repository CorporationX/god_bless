package faang.school.godbless.javamultithreading.task7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        System.out.println("Ведьмак прибыл в город " + city.getName());
        Optional<Monster> nearestMonster = findNearestMonster(city, monsters);

        nearestMonster.ifPresentOrElse(monster -> {
            System.out.println("В " + city.getName() + " найден " + monster.getName());
            long killTime = getKillTime();
            System.out.println("Время на убийство монстра: " + killTime + " миллисекунд");
        }, () -> System.out.println("В " + city.getName() + " нет монстров."));

        long journeyDistance = getJourneyDistance(city);
        System.out.println("В следующий город. Дистанция: " + journeyDistance + " километров.");
    }

    public Optional<Monster> findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        int minDistance = Integer.MAX_VALUE;
        int currentDistance;
        for (Monster monster : monsters) {
             currentDistance = calculateDistance(city.getLocation(), getLocationCoordinates(monster.getLocation()));
            if (minDistance > currentDistance) {
                minDistance = currentDistance;
                nearestMonster = monster;
            }
        }
        return Optional.ofNullable(nearestMonster);
    }

    public long getKillTime() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 5000L;
    }

    public long getJourneyDistance(City city) {
        return city.getDistanceFromWitcher();
    }

    private Location getLocationCoordinates(String location) {
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

    private int calculateDistance(Location cityLocation, Location monsterLocation) {
        // Формула AB = √(xb - xa)^2 + (yb - ya)^2
        double powX = Math.pow(cityLocation.getX() - monsterLocation.getX(), 2); // (xb - xa)^2
        double powY = Math.pow(cityLocation.getY() - monsterLocation.getY(), 2); // (yb - ya)^2
        return (int) Math.sqrt(powX + powY);
    }
}
