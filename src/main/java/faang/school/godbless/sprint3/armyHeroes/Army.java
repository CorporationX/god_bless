package faang.school.godbless.sprint3.armyHeroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {
    private final Map<String, List<Unit>> units = new HashMap<>();
    private final Map<String, UnitThread> unitThreads = new HashMap<>();
    @Getter
    private final Map<String, Integer> unitPowers = new HashMap<>();

    public void addUnit(Unit unit) {
        units.computeIfAbsent(unit.getName(), k -> new ArrayList<>()).add(unit);
    }

    private void startThreads() {
        units.forEach((key, value) -> {
            UnitThread unitThread = new UnitThread(value);
            unitThreads.put(key, unitThread);
            unitThread.start();
        });
    }

    public int calculateTotalPower() {
        startThreads();
        unitThreads.values()
                .forEach(unitThread -> {
            try {
                unitThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        unitThreads.forEach((key, value) -> unitPowers.put(key, value.getPower()));
        return unitPowers.values()
                .stream()
                .mapToInt(value -> value)
                .sum();
    }
}
