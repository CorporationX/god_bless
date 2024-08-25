package faang.school.godbless.BJS2_23410;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter
@Setter
public class Army {
    private List<Unit> armyList = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyList.add(unit);
    }

    public int calculateTotalPower() {
        Map<Class<? extends Unit>, List<Unit>> unitsByType = armyList.stream()
                .collect(Collectors.groupingBy(Unit::getClass));

        List<Thread> threads = new ArrayList<>();
        Map<Class<? extends Unit>, AtomicInteger> powerByType = new HashMap<>();

        for (Map.Entry<Class<? extends Unit>, List<Unit>> entry : unitsByType.entrySet()) {
            AtomicInteger totalPower = new AtomicInteger(0);
            powerByType.put(entry.getKey(), totalPower);

            Thread thread = new Thread(() -> {
                for (Unit unit : entry.getValue()) {
                    totalPower.addAndGet(unit.getPower());
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return powerByType.values().stream()
                .mapToInt(AtomicInteger::get)
                .sum();
    }
}
