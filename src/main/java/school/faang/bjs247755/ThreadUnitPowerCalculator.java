package school.faang.bjs247755;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUnitPowerCalculator extends Thread {
    private final Unit unit;
    private final AtomicInteger result;

    public ThreadUnitPowerCalculator(Unit unit, AtomicInteger result) {
        this.unit = unit;
        this.result = result;
    }

    @Override
    public void run() {
        result.addAndGet(unit.getPower());
    }
}
