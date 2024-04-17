package BJS2_5674;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Squad> squad = new ArrayList<>();
    private int allPowerUnit;

    public void addUnit(Squad unit) {
        squad.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        for (Squad unit : squad) {
            Thread thread = new Thread(() -> allPowerUnit += unit.getPower());
            thread.start();
            thread.join();
        }
        return allPowerUnit;
    }
}
