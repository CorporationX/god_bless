package Heroes_Of_Might_and_Magic_BJS2_35910;

import java.util.List;
import java.util.ArrayList;

public class Army {
    private List<Object> units = new ArrayList<>();

    public void addUnit(Object unit) {
        units.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        List<PowerCalculatorThread> threads = new ArrayList<>();

        for (Object unit : units) {
            PowerCalculatorThread thread = new PowerCalculatorThread(unit);
            threads.add(thread);
            thread.start();
        }
        int totalPower = 0;

        for (PowerCalculatorThread thread : threads) {
            thread.join();
            totalPower += thread.getResult();
        }
        return totalPower;
    }
}
