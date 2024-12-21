package school.faang.task_bjs248077;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> armyUnits = new ArrayList<>();

    public void addUnit(Unit unit) {
        armyUnits.add(unit);
    }

    public int calculateTotalPower() {
        int sum = 0;
        List<PowerCalculator> powers = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (Unit unit : armyUnits) {
            PowerCalculator calculator = new PowerCalculator(unit);
            powers.add(calculator);
            Thread thread = new Thread(calculator);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("ошибка с потоками");
            }
        }
        for (PowerCalculator power : powers) {
            sum += power.getPower();
        }
        return sum;
    }
}
