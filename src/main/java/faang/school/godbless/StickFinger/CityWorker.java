package faang.school.godbless.StickFinger;

import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class CityWorker implements Runnable {
    private static final int MINUTES_PER_UNIT = 2;
    private City city;

    public Monster closestMonster() {
        return Witcher.getMONSTERS().stream()
                .min(Comparator.comparingInt(monster -> Math.abs(city.getLocation() - monster.getLocation())))
                .orElse(null);
    }

    public int travelTime() {
        Monster monster = closestMonster();
        return Math.abs(city.getLocation() - monster.getLocation()) * MINUTES_PER_UNIT;
    }

    public int killTime() {
        return travelTime() + 5;
    }

    @Override
    public void run() {
        System.out.println("находясь в городе " + city.getName() + " убийство ближайшего монстра займёт " + killTime() + " минут");
    }
}
