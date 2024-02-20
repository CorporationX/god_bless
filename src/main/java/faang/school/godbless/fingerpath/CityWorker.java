package faang.school.godbless.fingerpath;

import java.util.List;
import java.util.Random;


public class CityWorker implements Runnable{
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
        Monster monster = findNearestMonster();
        System.out.println("The nearest monster to the city " + city.getName() + " is found: " + monster.getName());
        System.out.println("Time needed to kill " + monster.getName() + ": " + getKillTime() + " seconds");
        System.out.println("The distance to the the city " + city.getName()+ " is " + city.getDistance());
    }

    public Monster findNearestMonster(){
        return monsters.stream()
                .sorted((monster1, monster2) ->  Location.calculateDistance(city.getLocation(), monster2.getLocation())
                        - Location.calculateDistance(city.getLocation(), monster1.getLocation()))
                .toList().get(0);
    }
    public long getKillTime(){
        return new Random().nextInt(200);
    }
//    public long getJourneyDistance(){
//
//    }
}
