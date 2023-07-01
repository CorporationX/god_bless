package faang.school.godbless.witcher_map;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
public class CityWorker implements Runnable{
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Nearest monsters: " + city.getName() + ", " + findNearestMonster().getName());
        System.out.println("Nearest monsters kill time: " + getKillTime() + "h");
        System.out.println("Distance : " + getJourneyDistance());
    }

    public Monster findNearestMonster(){
        Location cityLocation = city.getLocation();
        Monster nearestMonster = null;
        int distance = Integer.MAX_VALUE;
        for (Monster monster : monsters){
            Location location  = monster.getLocation();

            int delta = getDelta(cityLocation, monster);
            if(delta < distance){
                distance = delta;
                nearestMonster = monster;
            }
        }
        return nearestMonster;
    }

    private int getDelta(Location cityLocation, Monster monster){
        int x = Math.abs(cityLocation.getX() - monster.getLocation().getX());
        int y = Math.abs(cityLocation.getY() - monster.getLocation().getY());

        return x + y;
    }

    public int getKillTime(){
        Random random = new Random();
        return random.nextInt(24) + 1;
    }

    public long getJourneyDistance(){
        return city.getDistance();
    }

}
