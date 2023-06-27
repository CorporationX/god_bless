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
            if(minDistance>(city.getLocation())-city.getDistances().get(monster.getLocation())) {
                minDistance = Math.min(minDistance, (city.getLocation()) - city.getDistances().get(monster.getLocation()));
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
        return getTimeForKillMonster() + Math.abs((city.getLocation()) - city.getDistances().get(searchNearestMonster().getLocation()))/4;
    }
}
