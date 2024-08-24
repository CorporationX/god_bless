package thread.seven;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {

        Monster nearestMonster = findNearestMonster(city, monsters);

        getJourneyDistance(city);
        getKillTime(nearestMonster);

    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = null;
        int minDistance = Integer.MAX_VALUE;

        for (Monster monster : monsters) {
            Location monsterLocation = getLocationCoordinates(monster.getLocation());
            int distance = Math.abs(city.getLocation().getX() - monsterLocation.getX()
                    + Math.abs(city.getLocation().getY() - monsterLocation.getY()));
            if (distance < minDistance) {
                minDistance = distance;
                nearestMonster = monster;
            }
        }
        System.out.println("Ближайший монстр от города " + city.getName() +
                ": " + nearestMonster.getName() + " из " + nearestMonster.getLocation());
        return nearestMonster;
    }

    public void getKillTime(Monster monster) {
        System.out.println("Битва началась!");
        try {
            Thread.sleep(1000);
            System.out.println("Монстр " + monster.getName() + " повержен.");
        } catch (InterruptedException e) {
            System.out.println("Геральда отвлекли от сражения, битва прекратилась.");
        }
    }

    public void getJourneyDistance(City city) {

        if (city.getRangeToGerald() == 0) {
            System.out.println("Геральд в городе " + city.getName());
        } else {
            System.out.println("Путешествие длинной " + city.getRangeToGerald() +
                    " км до города " + city.getName());
        }
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
}
