package faang.school.godbless.PavingTheWayWithYourFinger;

import java.util.List;

public class CityWorker implements Runnable {
    private final Monster monster;
    private final City city;

    public CityWorker(Monster monster, City city) {
        this.monster = monster;
        this.city = city;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        long distanceTillMonster = findDistance(city.getDistances(), monster.getLocation());
        try {
            System.out.println("Distance till "+ monster.getLocation()+ " is " + distanceTillMonster);
            Thread.sleep(city.getLocation());
            System.out.println("Fight with " + monster.getName());
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " minutes to kill the " + monster.getName() + " near the " + city.getName());
    }

    private long findDistance(List<Integer> distances, String monsterLocation) {
        if (monsterLocation.equals("Velen")){
            return distances.get(0);
        } else if (monsterLocation.equals("Toussaint")) {
            return distances.get(1);
        }else if (monsterLocation.equals("White Orchard")) {
            return distances.get(1);
        }else if (monsterLocation.equals("Skellige")) {
            return distances.get(1);
        }else {
            throw new IllegalArgumentException("Wrong location");
        }
    }
}
