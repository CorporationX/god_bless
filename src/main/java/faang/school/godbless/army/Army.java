package faang.school.godbless.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Unit> unitList = new ArrayList<>();

    public void addUnit(Unit unit) {
        unitList.add(unit);
    }

    public synchronized int calculateTotalPower() {
        int total = 0;
        for (Unit unit : unitList) {
            PowerThread thread = new PowerThread(unit.getPower());
            thread.start();

            total += thread.getPower();
        }

        return total;
    }
}
