package faang.school.godbless.army.heroes.might.magic;

import java.util.ArrayList;
import java.util.List;


public class Army {

    private List<UnitThread> unitThreads = new ArrayList<>();

    public int calculateTotalPower() {
        unitThreads.stream().forEach(unitThread -> unitThread.start());
        return unitThreads.stream().mapToInt(unitThread -> unitThread.getUnitPower()).sum();
    }

    public void addUnit(Unit unit) {
        unitThreads.add(new UnitThread(unit));
    }
}
