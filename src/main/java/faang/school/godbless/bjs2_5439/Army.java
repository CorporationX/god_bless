package faang.school.godbless.bjs2_5439;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Setter
public class Army {

    private int totalPower = 0;

    List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (Unit unit : army) {
            executorService.execute(() -> incrementTotalPower(unit));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                log.error("Time out end for this task");
                return 0;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return totalPower;
    }

    private synchronized void incrementTotalPower(Unit unit) {
        totalPower += unit.getPower();
    }
}
