package faang.school.godbless.Set_the_Path;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {

    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("I found a monster! city - " + city + ", monster - " + findNearestMonster());
        System.out.println("I'm going to kill it in : " + getKillTime() + " hours");
        System.out.println("The Distance to the city: " + getJourneyDistance());
    }

    public Monster findNearestMonster() {
        Location origin = city.getLocation();
        Map<Double, Monster> distances = new HashMap<>();
        monsters.forEach(x -> {
            Double distance = Location.getDistance(origin, x.getLocation());
            distances.put(distance, x);
        });
        Double needed = distances.keySet().stream().min(Double::compare).get();
        return distances.get(needed);
    }

    public long getKillTime() {
        return (long) ((Math.random() + 1) * 5);
    }

    public long getJourneyDistance() {
        return (long) city.getDistFromMage();
    }

}
