package faang.school.godbless.sprint.three.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private final Map<String, List<PowerThread>> unitsMap = new HashMap<>();
    private final Map<String, Integer> heroesPower = new HashMap<>();
    private final AtomicInteger totalHeroPower = new AtomicInteger(0);

    public int calculateTotalPower() throws InterruptedException {
        for (Map.Entry<String, List<PowerThread>> entry: unitsMap.entrySet()) {
            totalHeroPower.set(0);
            for (PowerThread thread : entry.getValue()) {
                thread.join();
                totalHeroPower.set(totalHeroPower.get() + thread.getPower());
            }
            heroesPower.put(entry.getKey(), totalHeroPower.get());
        }
        return heroesPower.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void addUnit(Unit unit) {
        String unitType = unit.getClass().getSimpleName();
        PowerThread powerThread = new PowerThread(unit);
        powerThread.start();
        unitsMap.computeIfAbsent(unitType, k -> new ArrayList<>()).add(powerThread);
    }
}
