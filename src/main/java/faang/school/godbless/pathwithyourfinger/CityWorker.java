package faang.school.godbless.pathwithyourfinger;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

@AllArgsConstructor
public class CityWorker implements Runnable{

    private City city;
    private List<Monster> monsters;

    @Override
    public void run(){
        System.out.println("Nearest monster to " + city.getName() + " is " + findNearestMonster().getName());
        System.out.println("Time to kill it: " + getKillTime() + " hours");
        System.out.println("Distance to " + city.getName() + ": " + getJourneyDistance());
    }

    public Monster findNearestMonster(){
        Monster nearestMonster = monsters.get(0);
        double minDistance = calculateDistance(city.getLocation(), Location.getLocationCoordinates(monsters.get(0).getLocation()));
        for (Monster monster : monsters) {
            double distance = calculateDistance(city.getLocation(), Location.getLocationCoordinates(monster.getLocation()));
            if(distance < minDistance){
                nearestMonster = monster;
                minDistance = distance;
            }
        }
        return nearestMonster;
    }

    public double calculateDistance(Location from, Location to){
        return sqrt(pow(from.getX() - to.getX(), 2) + pow(from.getY() - to.getY(), 2));
    }

    public long getKillTime(){
        return new Random().nextInt(11);
    }

    public long getJourneyDistance(){
        return city.getDistance();
    }

}
