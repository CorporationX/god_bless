package witcher;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class CityWorker implements Runnable {
    private final long RECHARGE = 100;
    private City city;
    private List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        System.out.println("Ближайший монстр к городу " + city.getName() + " это " + findNearestMonster().getName());
        System.out.println("Время для убийства этого монстра " + getKillTime());
        System.out.println("Дистанция до города " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Monster findMonster;
        CityWorker cityWorker = new CityWorker();
        int xCity = city.getGps().getX();
        int yCity = city.getGps().getY();
        Map<Integer, List<Monster>> monsterByDistance = new HashMap<>();
        for (Monster monster : monsters) {
            int xMons = monster.getGps().getX();
            int yMons = monster.getGps().getY();
            int distance = cityWorker.countDistance(xCity, yCity, xMons, yMons);
            cityWorker.something(monsterByDistance, distance, monster);
        }
        List<Map.Entry<Integer, List<Monster>>> newMonsList = makeList(monsterByDistance);
        findMonster = newMonsList.get(0).getValue().get(0);
        return findMonster;
    }

    private int countDistance(int xCity, int yCity, int xMons, int yMons) {
        int result = 0;
        int firstMove = xMons - xCity;
        int secondMove = yMons - yCity;
        int first = (int) Math.pow(firstMove, 2);
        int second = (int) Math.pow(secondMove, 2);
        int toResult = first + second;
        result = (int) Math.sqrt(toResult);
        return result;
    }

    private void something(Map<Integer, List<Monster>> monsterByDistance, int distance, Monster monster) {
        if (!monsterByDistance.containsKey(distance)) {
            List<Monster> newList = new ArrayList<>();
            newList.add(monster);
            monsterByDistance.put(distance, newList);
        } else {
            monsterByDistance.get(distance).add(monster);
        }
    }

    public long getKillTime() {
        long result = 0;
        Witcher witcher = new Witcher();
        for (Monster monster : monsters) {
            monster.setHealth(monster.getHealth() - witcher.getPower());
            witcher.setHealth(witcher.getHealth() - monster.getPower());
            result += RECHARGE;
            if (monster.getHealth() <= 0 && witcher.getHealth() <= 0) {
                break;
            }
        }
        return result;
    }

    public long getJourneyDistance() {
        return city.getDistance();
    }

    private List<Map.Entry<Integer, List<Monster>>> makeList(Map<Integer, List<Monster>> integerListMap) {
        List<Map.Entry<Integer, List<Monster>>> newMonsList = integerListMap.
                entrySet().
                stream().
                sorted(Comparator.comparingInt((x) -> x.getKey())).toList();
        return newMonsList;
    }
}
