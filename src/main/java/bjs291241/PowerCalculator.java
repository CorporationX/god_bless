package bjs291241;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class PowerCalculator implements Runnable {
    private final Squad squad;
    private final AtomicInteger totalPower;

    @Override
    public void run() {
        int squadPower = squad.calculateSquadPower();
        totalPower.addAndGet(squadPower);
        System.out.println(Thread.currentThread().getName()
                + " calculated squad " + squad.getClass() + " power: " + totalPower);
    }
}
