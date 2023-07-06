package faang.school.godbless.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> unitList = new ArrayList<>();

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public synchronized int calculateTotalPower() throws InterruptedException {
        int total = 0;
        for (Unit unit : unitList) {
            PowerThread thread = new PowerThread(unit);
            thread.start();
            thread.join();

            total += thread.getPower();
        }

        return total;
    }
}
