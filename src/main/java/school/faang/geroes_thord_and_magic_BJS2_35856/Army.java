package school.faang.geroes_thord_and_magic_BJS2_35856;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Army {
    private List<Unit> units;

    public Army(List<Unit> units) {
        this.units = units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public int calculateTotalPower(List<Unit> units) throws InterruptedException {
        List<PowerCalculator> actions = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        int totalPower = 0;

        for (Unit unit : units) {
            PowerCalculator calculator = new PowerCalculator(unit);
            actions.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (PowerCalculator calculator : actions) {
            totalPower += calculator.getPower();
        }

        return totalPower;
    }
}
