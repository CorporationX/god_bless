package faang.school.godbless.RoadWithFinger;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Getter
public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;

    @Override
    public void run() {
        System.out.println("Iщем монстра поблизости");
        Monster closestMonster = findNearestMonster(city, monsters);
        System.out.println("Монстр поблизости города " + city.getName() + " найден: " + closestMonster.getName());
        System.out.println("Расстояние от монстра " + closestMonster.getName() + " до города " + city.getName() + ": " + getJourneyDistance(city, closestMonster));
        System.out.println("Геральт отправляется в город " + city.getName());
        System.out.println("Ждем " + getKillTime() / 1000 + " секунд, пока Геральт расправляется с монстром в потоке " + Thread.currentThread().getName());
        getKillTime();
        System.out.println();
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {   //поиск ближайшего монстра
        long distanceCity = Integer.MAX_VALUE;
        Monster closestMonster = null;
        for (Monster monster : monsters) {
            long distanceCityMonster = city.getDistance() + getJourneyDistance(city, monster);
            if (distanceCityMonster < distanceCity) {
                distanceCity = distanceCityMonster;
                closestMonster = monster;
            }
        }
        return closestMonster;
    }


    public int getKillTime() {     //расчёт времени на убийство монстра
        return (new Random().nextInt(10) + 1) * 1000;
    }


    public long getJourneyDistance(City city, Monster monster) {       //дальность путешествия
        return (long) Math.sqrt(Math.pow((city.getLocation().getX() - monster.getLocationCoordinates(monster.getLocation()).getX()), 2)
                + Math.pow((city.getLocation().getY() - monster.getLocationCoordinates(monster.getLocation()).getY()), 2));
    }
}
