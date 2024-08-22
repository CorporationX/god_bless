package faang.school.godbless.sprint.three.heroes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private final Map<Unit, List<PowerThread>> unitsMap = new HashMap<>();
    private final Map<Unit, AtomicInteger> heroesPower = new HashMap<>();

    public int calculateTotalPower() throws InterruptedException {
        for (Map.Entry<Unit, List<PowerThread>> entry: unitsMap.entrySet()) {
            for (PowerThread thread : entry.getValue()) {
                thread.start();
            }
        }

        for (Map.Entry<Unit, List<PowerThread>> entry: unitsMap.entrySet()) {
            for (PowerThread thread : entry.getValue()) {
                thread.join();
                heroesPower.computeIfAbsent(entry.getKey(),
                        k -> new AtomicInteger(0)).addAndGet(thread.getPower());
            }
        }

        return heroesPower.values().stream().mapToInt(AtomicInteger::intValue).sum();
    }

    public void addUnit(Unit unit) {
        PowerThread powerThread = new PowerThread(unit);
        unitsMap.computeIfAbsent(unit, k -> new ArrayList<>()).add(powerThread);
    }
}
