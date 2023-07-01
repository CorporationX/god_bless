package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> units;

    public Army() {
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit){
        units.add(unit);
    }

    public int calculateTotalPower() {
        int totalPower = 0;

        List<PowerCalculatorThread> threads = new ArrayList<>();
        for(Unit unit : units){
            PowerCalculatorThread thread = new PowerCalculatorThread(unit);
            thread.start();
            threads.add(thread);
        }
        for (PowerCalculatorThread thread : threads) {
            try {
                thread.join();
                totalPower += thread.getUnitPower();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return totalPower;
    }
}
