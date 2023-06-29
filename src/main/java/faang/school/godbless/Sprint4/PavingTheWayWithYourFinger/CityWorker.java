package faang.school.godbless.Sprint4.PavingTheWayWithYourFinger;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    @SneakyThrows
    @Override
    public void run() {
        Monster monster = findNearestMonster(city, monsters);
        Thread.sleep(getJourneyDistance(city.getLocationCity(), monster.getLocation()));
        Thread.sleep(getKillTime());
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        return monsters.stream()
                .min((m1, m2) ->
                        Double.compare(getJourneyDistance(city.getLocationCity(), m1.getLocation())
                                , getJourneyDistance(city.getLocationCity(), m2.getLocation()))
                ).orElse(null);
    }

    //Констата для объективного сравнения
    public long getKillTime(){
        return 1000;
    }

    public long getJourneyDistance(Location location1, Location location2){
        double deltaX = location2.getX() - location1.getX();
        double deltaY = location2.getY() - location1.getY();
        double distance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return (long) distance;
    }
}

