package school.faang.task_47785;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Army {
    private final List<Unit> unitList = new ArrayList<>();
    private final AtomicInteger totalPower = new AtomicInteger(0);

    public int calculateTotalPower() {
        List<Thread> threadList = new ArrayList<>(unitList.size());
        unitList.forEach(unit -> threadList.add(new Thread(() ->
                totalPower.addAndGet(unit.getPower()))));

        threadList.forEach(Thread::start);
        try {
            for (Thread thread : threadList) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error("Error occurred: {}", e.getMessage());
        }
        return totalPower.get();
    }

    public void addUnit(Unit unit) {
        unitList.add(Optional.ofNullable(unit)
                .orElseThrow(() -> new IllegalArgumentException("Unit cannot be null")));
    }
}
