package faang.school.godbless.distributedarmy2850;

import faang.school.godbless.distributedarmy2850.troop.Unit;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Army {

    private List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public int calculateTotalPower() throws InterruptedException {
        List<ArmyPowerCalculatorThread> threads = new ArrayList<>();
        for (Unit unit : units) {
            ArmyPowerCalculatorThread thread = new ArmyPowerCalculatorThread(unit);
            threads.add(thread);
            thread.start();
        }
        int totalPower = 0;

        for (ArmyPowerCalculatorThread thread : threads) {
            thread.join();
            totalPower += thread.getPower();
        }

        return totalPower;
    }
}
