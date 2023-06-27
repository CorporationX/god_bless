package sprint4.homm;

import lombok.Data;
import sprint4.homm.unit.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
public class Army {
    private static final int NUMBER_THREAD = 4;
    private final List<Unit> units = new ArrayList<>();

    public int calculateTotalPower() {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_THREAD);
        for (Unit unit : units) {
            service.execute(new PowerCounterThread(unit));
        }
        try {
            service.awaitTermination(1, TimeUnit.SECONDS);
            service.shutdownNow();
        } catch (InterruptedException e) {
            System.out.println("Работа была прервана");
        }
        return PowerCounterThread.getTotalPower();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}
