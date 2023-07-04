package faang.school.godbless.threads.vedmak;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Map<Double, Monster> distanceMap = new HashMap<>();
        for (Monster monster : monsters) {
            double distance = Location.getDistance(Location.getCoordinates(monster.getLocation()), city.getCoordinates());
            distanceMap.put(distance, monster);
        }
        return distanceMap.get(Collections.min(distanceMap.keySet()));
    }

    public long getKillTime(Monster monster) {
        switch (monster.getName()) {
            case "Griffin" -> {
                return 5;
            }
            case "Basilisk" -> {
                return 15;
            }
            case "Cockatrice" -> {
                return 11;
            }
            case "Chort" -> {
                return 80;
            }
            default -> {
                return 0;
            }
        }
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        long killingTime = getKillTime(monster);
        long distance = getJourneyDistance();
        System.out.printf("Город - %s. Ближайший монстр %s и убивать его нужно %d минут. Дистанция - %d\n",
                city.getCityName(), monster.getName(), killingTime, distance);
    }
}
