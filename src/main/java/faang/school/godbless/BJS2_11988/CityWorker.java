package faang.school.godbless.BJS2_11988;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CityWorker implements Runnable {

    private List<City> cities;
    private Witcher witcher;
    private Location startLocation;
    private List<Monster> monsters;

    public CityWorker(List<City> cities, Witcher witcher) {
        this.cities = cities;
        this.witcher = witcher;
        this.startLocation = witcher.getLocation();
    }

    public void addMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public Monster findNearestMonster(City city, List<Monster> monsters) {
        Monster nearestMonster = monsters.get(0);
        double distance = calcDistance(city.getLocation(), monsters.get(0).getLocation());
        for (Monster monster : monsters) {
            double tempDistance = calcDistance(city.getLocation(), monster.getLocation());
            if (tempDistance < distance) {
                distance = tempDistance;
                nearestMonster = monster;
            }
        }
        goToMonster(nearestMonster);
        return nearestMonster;
    }

    private double calcDistance(Location location1, Location location2) {
        return Math.sqrt(Math.pow((location1.getX() - location2.getX()), 2) + Math.pow((location1.getY() - location2.getY()), 2));
    }

    public double getKillTime() {
        double time = 0d;
//        int delay = new Random().nextInt(5,25);
        int delay = 5;
        try {
            TimeUnit.SECONDS.sleep(delay);
            time = delay;
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        return delay;
    }

    public double getJourneyDistance() {
        return calcDistance(startLocation, witcher.getLocation());
    }

    public void goToCity(City city) {
        witcher.setCity(city);
        witcher.setLocation(city.getLocation());
        updateCitiesDistances();
    }

    private void goToMonster(Monster monster) {
        witcher.setLocation(monster.getLocation());
        witcher.getCity().setDistance(calcDistance(witcher.getCity().getLocation(), witcher.getLocation()));
    }

    private void updateCitiesDistances() {
        cities.forEach(city -> city.setDistance(calcDistance(city.getLocation(), witcher.getLocation())));
    }

    @Override
    public void run() {

        System.out.println("Withcer started his journey from " + witcher.getCity().getName());
        Monster nearestMonster = findNearestMonster(witcher.getCity(), monsters);
        System.out.println(nearestMonster.getMonsterName() + " is the nearest monster to Witcher's recent location");
        System.out.println("He decided to hunt it down and defeat it");
        System.out.println("After " + getKillTime() + " seconds he finally managed to defeat the monster and got the trophy");
        System.out.println("Journey was " + getJourneyDistance() + " miles and now he is " + witcher.getCity().getDistance() + " from " + witcher.getCity().getName());


    }
}
