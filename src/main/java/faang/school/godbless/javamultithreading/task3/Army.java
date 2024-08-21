package faang.school.godbless.javamultithreading.task3;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> units = new ArrayList<>();
    private final List<PowerThread> powerThreads = new ArrayList<>();

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower() {
        units.forEach(unit -> {
            PowerThread powerThread = new PowerThread(unit);
            powerThreads.add(powerThread);
            powerThread.start();
        });
        return powerThreads.stream()
                .peek(powerThread -> {
                    try {
                        powerThread.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .mapToInt(PowerThread::getPower)
                .sum();
    }
}
