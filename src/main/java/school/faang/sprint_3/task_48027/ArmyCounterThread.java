package school.faang.sprint_3.task_48027;

import lombok.Getter;

import java.util.List;

public class ArmyCounterThread extends Thread {
    @Getter
    private int sumPower = 0;
    private final List<Unit> armySubList;

    public ArmyCounterThread(List<Unit> armySubList) {
        this.armySubList = armySubList;
    }

    @Override
    public void run() {
        for (Unit unit : armySubList) {
            sumPower += unit.getPower();
        }
    }
}
