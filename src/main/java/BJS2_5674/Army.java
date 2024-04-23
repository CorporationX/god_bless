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
        List<Thread> threads = new ArrayList<>();
        for (Squad unit : squad) {
            Thread thread = new Thread(() -> allPowerUnit += unit.getPower());
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException();
            }
        }
        return allPowerUnit;
    }
}
