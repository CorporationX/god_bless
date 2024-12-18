package school.faang.sprint_3.task_bjs247927;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public record Army(List<Unit> units) {
    public int calculateTotalPower() {
        final AtomicInteger totalPower = new AtomicInteger();
        List<PowerCalculateThread> threads = new ArrayList<>();

        units.forEach(unit -> {
            PowerCalculateThread thread = new PowerCalculateThread(unit);
            threads.add(thread);
            thread.start();
        });

        threads.forEach(thread -> {
            joinWithHandler(thread);
            totalPower.addAndGet(thread.getPower());
        });
        return totalPower.get();
    }

    private void joinWithHandler(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            log.error("Thread {} was interrupted", thread);
            Thread.currentThread().interrupt();
        }
    }
}
