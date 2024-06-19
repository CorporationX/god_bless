package faang.school.godbless.HeroesOfMightAndMagic;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private static List<Unit> army = new ArrayList<>();
    private static List<ThreadUnitPower> threadUnitPowers = new ArrayList<>();

    public static void addUnit(Unit unit) {
        army.add(unit);
    }

    public static int calculateTotalPower() throws InterruptedException {
        int powerArmy = 0;
        startTreads();
        for (ThreadUnitPower unitPower : threadUnitPowers) {
            unitPower.join();
            powerArmy += unitPower.getPower();
        }
        return powerArmy;
    }

    public static void startTreads() {
        for (Unit unit : army) {
            ThreadUnitPower unitPower = new ThreadUnitPower(unit);
            unitPower.start();
            threadUnitPowers.add(unitPower);
        }
    }
}
