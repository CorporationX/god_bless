package faang.school.godbless.sprint3.BJS2_23891;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    public Monster findNearestMonster() {
        Monster nearestMonster = null;
        double nearestDistance = Double.MAX_VALUE;

        Location cityLocation = city.getCityLocation();

        for (Monster monster : monsters) {
            Location monsterLocation = monster.getMonsterLocation();

            double distance = Math.sqrt(Math.pow(monsterLocation.getX() - cityLocation.getX(), 2)
                    + Math.pow(monsterLocation.getY() - cityLocation.getY(), 2));

            if (nearestMonster == null || distance < nearestDistance) {
                nearestMonster = monster;
                nearestDistance = distance;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(Monster monsterNearCity) {
        long killTime = 0;
        killTime = switch (monsterNearCity.getMonsterName()) {
            case "Griffin" -> 5;
            case "Basilisk" -> 10;
            case "Cockatrice" -> 7;
            case "Chort" -> 3;
            default -> {
                System.out.println("Can not identify a monster");
                yield 0;
            }
        };
        return killTime;
    }

    public double getJourneyDistance() throws IOException {
        Location witcherLocation = Witcher.cities.stream()
                .filter(c -> c.getDistanceToWitcher() == 0)
                .map(City::getCityLocation)
                .findFirst()
                .orElseThrow(() -> new IOException("Error! Multiple values were found!"));

        return witcherLocation.getDistanceBetweenLocations(city.getCityLocation());
    }


    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        try {
            System.out.printf("City: %s%n" +
                            "Nearest monster: %s%n" +
                            "Monster killing time: %d%n" +
                            "Journey distance to city %s: %f%n%n",
                    city.getCityName(), nearestMonster.toString(), getKillTime(nearestMonster), city.getCityName(), getJourneyDistance());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
