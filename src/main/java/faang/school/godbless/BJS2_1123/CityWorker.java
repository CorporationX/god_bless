package faang.school.godbless.BJS2_1123;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsterList;

    public Monster findNearestMonster(City city, List<Monster> monsters){
        double distance=0;
        double nearestDistance = Integer.MAX_VALUE;
        Monster result = new Monster("mistake", new Location(-1, 1));
        for (Monster monster : monsters) {
            double firstHalf = pow((city.getLocation().getX()-monster.getLocation().getX()), 2);
            double secondHalf = pow((city.getLocation().getY()-monster.getLocation().getY()), 2);
            distance = sqrt(firstHalf+secondHalf);
            if(nearestDistance>distance) {
                nearestDistance = distance;
                result.setName(monster.getName());
                result.setLocation(monster.getLocation());
            }
        }
        return result;
    }

    public long getKillTime() {
        return new Random().nextInt(100);
    }

    public long getJourneyDistance(City city) {
        double firstHalf = pow((city.getLocation().getX()-180), 2);
        double secondHalf = pow((city.getLocation().getY()-70), 2);
        return (long) sqrt(firstHalf+secondHalf);
    }

    @Override
    public void run() {
        System.out.println("Nearest Monster to city "+city.getNameCity()+" is "+findNearestMonster(city, monsterList));
        System.out.println("Time to kill monster: "+getKillTime());
        System.out.println("Distance to the city "+city.getNameCity()+" is "+getJourneyDistance(city));
    }
}
