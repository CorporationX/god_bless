package school.faang.sprint_3.task_43550;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Unit> army = new ArrayList<>();

    public void addUnit(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() {
        PowerCalculator powerCalculator;
        Thread thread;
        int totalPower = 0;

        List<Thread> threads = new ArrayList<>();
        List<PowerCalculator> calculators = new ArrayList<>();

        for (Unit unit : army) {
            powerCalculator = new PowerCalculator(unit);
            calculators.add(powerCalculator);
            thread = new Thread(powerCalculator);
            threads.add(thread);
            thread.start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван во время ожидания.");
            }
        }

        for (PowerCalculator calculator : calculators) {
            totalPower += calculator.getPower();
        }

        return totalPower;
    }
}
