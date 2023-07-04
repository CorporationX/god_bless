package faang.school.godbless.Sprint_4.Multithreading_Parallelism.Path_TheWitcher;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable {

    private List<City> cities;
    private City city;
    private List<Monster> monsters;


    @Override
    public void run() {
        for(int i = 0; i < monsters.size(); ++i) {
            Monster monster = findNearestMonster(city, monsters);
            System.out.println("Fight with  " + monster.getName() + " is starting...");
            try {
                Thread.sleep(getKillTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(monster.getName() + " is dead!");
            //monsters.remove(monster);
            city = findNearestCity(cities, monster);
        }
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        long distance = Long.MAX_VALUE;
        Monster nearestMonster = null;
        Location cur = city.getLocation();
        for (Monster monster : monsters) {
            long monsterDistance = Location.getDistance(cur, monster.getLocation());
            if (monsterDistance < distance) {
                distance = monsterDistance;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public City findNearestCity(List<City> cities, Monster monster) {
        long distance = 1000000;
        City nearestCity = null;
        Location cur = monster.getLocation();
        for (City city : cities) {
            long cityDistance = Location.getDistance(cur, city.getLocation());
            if (cityDistance < distance) {
                distance = cityDistance;
                nearestCity = city;
            }
        }
        return nearestCity;
    }




    public long getKillTime() {
        return new Random().nextLong(15000);
    }

    public static double getJourneyDistance(City firstCity, City secondCity) {
        return Location.getDistance(firstCity.getLocation(), secondCity.getLocation());
    }
}
