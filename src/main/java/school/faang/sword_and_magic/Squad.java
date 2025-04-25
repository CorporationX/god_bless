package school.faang.sword_and_magic;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private final List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateSquadPower() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread: " + threadName + " has count power of a squad: " + units.size() + " units");

        int power = units.stream().mapToInt(Unit::getPower).sum();

        System.out.println("Thread: " + threadName + " ended calculations of a power = " + power + " points");
        return power;
    }
}
