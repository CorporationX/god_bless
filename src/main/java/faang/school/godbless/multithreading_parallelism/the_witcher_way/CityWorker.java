package faang.school.godbless.multithreading_parallelism.the_witcher_way;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
@Getter
public class CityWorker implements Runnable{

    private City city;
    private List<Monster> monsterList;

    @Override
    public void run() {
        System.out.println("Ближайший монстр в городе " + city.getName() + " это " + findNearestMonster().getName());
        System.out.println("Время сражения " + getKillTime() + " часов");
        System.out.println("Дистация до города " + getJourneyDistance());
    }

    public Monster findNearestMonster(){
        Location cityLocation = city.getLocation();
        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;
        for(Monster monster: monsterList){
            Location monsterLocation = monster.getCoordinates();

            int distanceToMonster = getDistanceToMonster(cityLocation, monsterLocation);

            if(distance > distanceToMonster){
                distance = distanceToMonster;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private int getDistanceToMonster(Location cityLocation, Location monsterLocation){
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());
        return deltaX + deltaY;
    }

    public long getKillTime(){
        return (long) ((Math.random()+1) * 10);
    }

    public long getJourneyDistance(){
        return city.getDistance();
    }
}
