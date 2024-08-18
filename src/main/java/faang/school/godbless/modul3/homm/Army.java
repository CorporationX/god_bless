package faang.school.godbless.modul3.homm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Army {
    private int totalPower;
    private final List<Unit> army = new ArrayList<>();

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        army.forEach(unit -> executorService.execute(() -> incrementTotalPower(unit)));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Time out end for this task");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return totalPower;
    }

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    private synchronized void incrementTotalPower(Unit unit) {
        totalPower += unit.getPower();
    }
}
