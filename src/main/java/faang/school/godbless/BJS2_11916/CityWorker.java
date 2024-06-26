package faang.school.godbless.BJS2_11916;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Ведьмак находится в городе: " + city);
        Monster currentMonster = findNearestMonster(city, monsters);
        System.out.println("Ближайший монстр для уничтожения: " + currentMonster);
        int distance = getJourneyDistance(city.getLocation(), currentMonster.getLocation());
        System.out.println("Расстояние до монстра: " + distance);
        int killTime = getKillTime();
        System.out.println("Время на убийство монстра составит: " + killTime / 1000 + " секунды");
        System.out.println("Ведьмак отправился на охоту");
        try {
            Thread.sleep(killTime);
            monsters.remove(currentMonster);
            System.out.println("Монстр " + currentMonster + " убит");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Map<Monster, Integer> monsterDistance = new HashMap<>();
        monsters.forEach(monster -> monsterDistance.putIfAbsent(monster, getJourneyDistance(city.getLocation(), monster.getLocation())));
        return monsterDistance.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(IllegalStateException::new)
                .getKey();
    }

    public int getKillTime() {
        return new Random().nextInt(2000, 8000);
    }

    private int getJourneyDistance(Location departure, Location destination) {
        int xDeparture = departure.getX();
        int yDeparture = departure.getY();
        int xDestination = destination.getX();
        int yDestination = destination.getY();
        return (int) Math.ceil(Math.sqrt(Math.abs(Math.pow(xDestination, 2) - Math.pow(xDeparture, 2)) +
                Math.abs(Math.pow(yDestination, 2) - Math.pow(yDeparture, 2))));
    }
}
