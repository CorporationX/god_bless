package faang.school.godbless.BJS2_5732;

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
        List<PowerOfUnit> unitsThread = new ArrayList<>();
        for (Character unit : army) {
            PowerOfUnit unitThread = new PowerOfUnit(unit);
            unitsThread.add(unitThread);
            unitThread.start();
        }
        for (PowerOfUnit unit : unitsThread) {
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
