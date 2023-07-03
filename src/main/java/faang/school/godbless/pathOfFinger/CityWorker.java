package faang.school.godbless.pathOfFinger;

import lombok.Data;
import lombok.NonNull;

import java.util.List;
@Data
public class CityWorker implements Runnable{
    @NonNull
    private City city;
    @NonNull
    List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Необходимое время на путешествие " + getTimeForJourney() + " дней");
    }

    public Monster searchNearestMonster(){
        Monster requiredMonster = null;
        int minDistance = Integer.MAX_VALUE;
        for (var monster : monsters){
            int distanceToMonster = city.getDistances().get(monster.getLocation());
            if(minDistance>(city.getLocation())-distanceToMonster) {
                minDistance = Math.min(minDistance, (distanceToMonster));
                requiredMonster = monster;
            }
        }
        if(requiredMonster == null){
            throw new NullPointerException("Монстров больше нет");
        }
        System.out.println("Найден монстер " + requiredMonster.getName());
        return requiredMonster;
    }

    public int getTimeForKillMonster(){
        return (int)(Math.random()*10);
    }
    public int getTimeForJourney(){
        final int MOVESPEED = 4;
        int distanceToNearestMonster = city.getDistances().get(searchNearestMonster().getLocation());
        return getTimeForKillMonster() + Math.abs(city.getLocation() - distanceToNearestMonster)/MOVESPEED;
    }
}
