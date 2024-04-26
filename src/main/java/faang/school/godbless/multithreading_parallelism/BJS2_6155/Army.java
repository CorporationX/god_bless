package faang.school.godbless.multithreading_parallelism.BJS2_6155;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Character> army;

    public Army() {
        this.army = new ArrayList<>();
    }

    public void addUnit(Character character) {
        army.add(character);
    }

    public int calculateTotalPower() {
        int totalPower = 0;
        List<UnitThread> unitsThread = new ArrayList<>();

        for (Character unit : army) {
            UnitThread unitThread = new UnitThread(unit);
            unitsThread.add(unitThread);
            unitThread.start();
        }

        for (UnitThread unit : unitsThread) {
            try {
                unit.join();
                totalPower += unit.getPower();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        return totalPower;
    }
}
