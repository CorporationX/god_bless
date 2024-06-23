package faang.school.godbless.make_your_path_with_finger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CityWorker implements Runnable {

    private final City city;
    private final List<Monster> monsters;


    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = new ArrayList<>(monsters);
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
//       Comparator for distance to monster location
        return monsters.stream()
                .min(Comparator.comparingDouble(monster -> Location.distance(Location.getLocationCoordinates(monster.location()), city.location())))
                .orElseThrow();
    }

    public long getKillTime() {
        return (long) new Random().nextInt(100);
    }

    public long getJourneyDistance() {
        return city.distance();
    }

    @Override
    public void run() {
        System.out.println("Travel distante to " + city.name() + " is " + city.distance() + ". To hunt" + findNearestMonster(city, monsters) + " in " + getKillTime() + " hours");
    }
}
