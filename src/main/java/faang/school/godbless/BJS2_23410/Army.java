package faang.school.godbless.BJS2_23410;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Army {
    private Map<Class<? extends Unit>, List<Unit>> unitsByType = new HashMap<>();
    private AtomicInteger totalPower = new AtomicInteger(0);

    public void addUnit(Unit unit) {
        unitsByType.computeIfAbsent(unit.getClass(), units -> new ArrayList<>()).add(unit);
    }

    public int calculateTotalPower() {
        totalPower.set(0);

        List<Thread> threads = unitsByType.values().stream()
                .map(units -> new Thread(() -> {
                    int typePower = units.stream()
                            .mapToInt(Unit::getPower)
                            .sum();
                    totalPower.addAndGet(typePower);
                }))
                .toList();

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return totalPower.get();
    }
}
