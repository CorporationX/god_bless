package faang.school.godbless.sprint.three.heroes;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Army {
    private final Map<String, PowerThread> unitsMap = new HashMap<>();
    private final AtomicInteger allPower = new AtomicInteger(0);

    public int calculateTotalPower() throws InterruptedException {
        unitsMap.forEach((key, thread) -> thread.start());
        unitsMap.forEach((key, thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        return allPower.get();
    }

    public void addUnit(Unit unit) {
        unitsMap.computeIfAbsent(unit.getClass().getName(), k -> new PowerThread(allPower)).addUnit(unit);
    }
}
