package BJS2_23892_PathByFinger;

import java.util.List;

public class CityWorker implements Runnable {

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster monsterToFind = null;
        for (Monster monster : monsters) {
            Location targetMonster = new Location(Double.MAX_VALUE, Double.MAX_VALUE);
            Location monsterLocation = new Location(city.getLocation().getX() - monster.getLocation().getX(),
                    city.getLocation().getX() - monster.getLocation().getY());
            if ((targetMonster.getX() + targetMonster.getY()) < (monsterLocation.getX() + monsterLocation.getY())) {
                monsterToFind = monster;
            }
        }
        return monsterToFind;
    }

    public long getKillTime(){
        return 0;
    }

    public long getJourneyDistance(City city){
        if(city.getCityName().equals("Kaer Morhen")){
            return 0;
        }
    }

    @Override
    public void run() {

    }
}
