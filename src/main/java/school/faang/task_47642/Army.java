package school.faang.task_47642;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private final int COUNT_THREAD = 3;
    private int powerArmy = 0;
    private List<Unit> units = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public List<Thread> calculateTotalPower() {

        List<Unit> threadUnit = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        int countUnit = units.size() / COUNT_THREAD;
        for (int i = 0; i < units.size(); i++) {
            threadUnit.add(units.get(i));
            if ((i + 1) % countUnit == 0) {
                List<Unit> finalThreadUnit1 = threadUnit;
                threads.add(new Thread(() -> calculate(finalThreadUnit1)));
                threadUnit = new ArrayList<>();
            }
        }
        if (!threadUnit.isEmpty()) {
            List<Unit> finalThreadUnit2 = threadUnit;
            threads.add(new Thread(() -> calculate(finalThreadUnit2)));
        }
        return threads;
    }

    public void calculate(List<Unit> unitsPower) {
        for (Unit unit : unitsPower) {
            powerArmy += unit.getPower();
        }
    }
}
