package school.faang.sprint_3.task_47956;

import lombok.Getter;

import java.util.List;

@Getter
public class PowerCalculatorThread extends Thread {
    private final List<Unit> units;
    private int totalPower;

    public PowerCalculatorThread(List<Unit> units) {
        this.units = units;
    }

    @Override
    public void run() {
        for (Unit unit : units) {
            totalPower += unit.getPower();
        }
    }
}
