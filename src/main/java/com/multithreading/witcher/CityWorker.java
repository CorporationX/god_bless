package com.multithreading.witcher;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CityWorker implements Runnable {
    private City city;
    private List<Monster> monsters;
    private Map<String, Location> locations;

    public CityWorker(City city, List<Monster> monsters, Map<String, Location> locations) {
        this.city = city;
        this.monsters = monsters;
        this.locations = locations;
    }

    public Map<Monster, Integer> findNearestMonster() {
        Map<Monster, Integer> nearestMonster = new HashMap<>();
        Monster monster = monsters.stream().min(Comparator
                .comparing(monster1 -> calculateDistance(city.getLocation(),
                        locations.get(monster1.getLocation()))))
                .get();
        int distanceToMonster = calculateDistance(city.getLocation(), locations.get(monster.getLocation()));
        nearestMonster.put(monster, distanceToMonster);
        return nearestMonster;
    }

    public long getKillTime() {
        return (int) (Math.random() * ((5-1) + 1) + 1);
    }

    public int getJourneyDistance(City city) {
        return city.getDistance();
    }

    public int calculateDistance(Location location1, Location location2) {
        return (int) Math.round(Math.sqrt(Math.pow(location2.getX() - location1.getX(), 2) +
                Math.pow(location2.getY() - location1.getY(), 2)));
    }

    @Override
    public void run() {
        for (Map.Entry<Monster, Integer> entry : findNearestMonster().entrySet()) {
            System.out.println("Монстр " + entry.getKey() + " расстояние от " + city.getName() + " = " + entry.getValue());
            System.out.println("Нужно пройти до города " + city.getName() + " " + getJourneyDistance(city));
            System.out.println("Время на убийства " + entry.getKey() + " = " + getKillTime());
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
    }
}

