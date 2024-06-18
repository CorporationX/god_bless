package faang.school.godbless.BJS211004;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Army {

    private Map<String, List<Unit>> unitsByType = new HashMap<>();

    public void addUnit(Unit unit) {
        unitsByType.computeIfAbsent(unit.getClass().getSimpleName(), k -> new ArrayList<>()).add(unit);
    }

    @SneakyThrows
    public int calculateTotalPower() {
        int totalPower = 0;
        List<PowerCalculateThread> threads = new ArrayList<>();

        for (Map.Entry<String, List<Unit>> entry : unitsByType.entrySet()) {
            var thread = new PowerCalculateThread(entry.getValue());
            threads.add(thread);
            thread.start();
        }

        for (PowerCalculateThread thread : threads) {
            thread.join();
            totalPower+=thread.getPowerSum();
        }

        return totalPower;
    }
}
