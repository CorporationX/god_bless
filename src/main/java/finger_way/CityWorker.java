package finger_way;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;
@Getter
@AllArgsConstructor
public class CityWorker implements Runnable{
    private City city;
    private final List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("nearest monster to city " + city.getName() + " id " + findNearestMonster().getName());
        System.out.println("time to kill " + getKillTime());
        System.out.println("Distance to the " + getJourneyDistance());
    }
    public Monster findNearestMonster() {
        return monsters.stream()
                .min(Comparator.comparingInt(monster -> getDeltaSum(city.getLocation(), monster.getVillagelocation())))
                .orElse(null);
    }
    private int getDeltaSum(Location cityLocation, Location monsterLocation){
        int deltaX = Math.abs(cityLocation.getX() - monsterLocation.getX());
        int deltaY = Math.abs(cityLocation.getY() - monsterLocation.getY());
        return deltaX + deltaY;
    }
   public long getKillTime(){
       return Math.round((Math.random() + 1) * 10);
    }
    public long getJourneyDistance(){
        return city.getDistance();
    }
}
