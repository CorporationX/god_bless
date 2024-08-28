package faang.school.godbless;

import faang.school.godbless.data.City;
import faang.school.godbless.data.Monster;

import java.util.List;

public class CityWorker implements Runnable {
    private City city;
    private List<City> cities;
    private List<Monster> monsters;
    private int cityIndex;

    public CityWorker(City city, int cityIndex, List<City> cities, List<Monster> monsters) {
        this.cities = cities;
        this.cityIndex = cityIndex;
        this.monsters = monsters;
        this.city = city;
    }

    @Override
    public void run() {
        Monster nearestMonster = findNearestMonster();
        int travelTime = calculateTravelTime(nearestMonster);
        int killTime = calculateKillTime(nearestMonster);
        int totalTime = travelTime + killTime;

        System.out.println("City: " + city.getName() +
                ", Nearest Monster: " + nearestMonster.getName() +
                ", Travel Time: " + travelTime +
                ", Kill Time: " + killTime +
                ", Total Time: " + totalTime);
    }

    private Monster findNearestMonster(){
        return monsters.get(0);
    }

    private int calculateTravelTime(Monster monster){
        return city.getDistanceToCity(cityIndex);
    }

    private int calculateKillTime(Monster monster) {
        return 10;
    }
}
