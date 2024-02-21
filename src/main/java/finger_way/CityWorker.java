package finger_way;

import java.util.List;

public class CityWorker implements Runnable{
    private final City city;
    private final List<Monster> monsters;

    public CityWorker(City city, List<Monster> monsters) {
        this.city = city;
        this.monsters = monsters;
    }

    @Override
    public void run() {
    }
    public Monster findNearestMonster(City city, List<Monster> monsters){
        find monster = City.Location - monsters.location;
    }
    public long getKillTime(){
        Thread.sleep();
    }
    public long getJourneyDistance(){

    }
}
