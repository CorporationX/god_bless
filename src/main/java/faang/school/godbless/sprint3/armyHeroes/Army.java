package faang.school.godbless.sprint3.armyHeroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private final Map<Unit, List<UnitThread>> unitThreadsMap = new HashMap<>();
    @Getter
    private final Map<String, Integer> unitPowers = new HashMap<>();

    public void addUnit(Unit unit) {
        startThread(unit);
    }

    private void startThread(Unit unit) {
        UnitThread unitThread = new UnitThread(unit);
        unitThreadsMap.computeIfAbsent(unit, k -> new ArrayList<>()).add(unitThread);
        unitThread.start();
    }

    public void calculateUnitsPower() throws InterruptedException {
        for (Unit unit : unitThreadsMap.keySet()) {
            calculateUnitPower(unit);
        }
    }

    public int calculateTotalPower() throws InterruptedException {
        calculateUnitsPower();
        return unitPowers.values()
                .stream()
                .mapToInt(value -> value)
                .sum();
    }

    public void calculateUnitPower(Unit unit) throws InterruptedException {
        int totalUnitPower = 0;
        for (UnitThread unitThread : unitThreadsMap.get(unit)) {
            unitThread.join();
            totalUnitPower += unitThread.getPower();
        }
        unitPowers.put(unit.getName(), totalUnitPower);
    }
}
