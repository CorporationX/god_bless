package faang.school.godbless;

import lombok.AllArgsConstructor;

import java.util.List;

import static java.lang.Math.pow;

@AllArgsConstructor
public class CityWorker implements Runnable{
    private City city;
    List<Monster> monsters;

    public Monster findNearestMonster(){
        Location cityLocation = city.getLocation();
        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;
        for (Monster monster : monsters) {
            Location monsterLocation = monster.getVillageLocation();

            int distanceToMonster = getDeltaDistance(cityLocation, monsterLocation);

            if(distanceToMonster < distance){
                distance = distanceToMonster;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    public long getKillTime(){
        return (long) ((Math.random() + 1) * 10);
    }


    public int getDeltaDistance(Location cityLocation, Location monsterLocation){
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());

        return (int) Math.sqrt(pow(deltaX, 2) + pow(deltaY, 2));
    }
    @Override
    public void run() {
        System.out.println("Nearest monster to city " + city.getName() + "is: " + findNearestMonster().getName());
        System.out.println("Time to kill it: " + getKillTime() + " hours");
        System.out.println("Distance to city: " + getDeltaDistance(city.getLocation(), findNearestMonster().getVillageLocation()));
    }
}
