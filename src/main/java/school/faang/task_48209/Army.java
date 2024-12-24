package school.faang.task_48209;

import java.util.ArrayList;
import java.util.List;

public class Army {
    List<Unit> army = new ArrayList<>();

    public void addFighter(Unit unit) {
        army.add(unit);
    }

    public int calculateTotalPower() throws InterruptedException {
        int totalPower = 0;
        List<Thread> threads = new ArrayList<>();
        List<CalculatePower> tasks = new ArrayList<>();

        for (Unit unit : army) {
            CalculatePower calculate = new CalculatePower(unit);
            tasks.add(calculate);
            Thread thread = new Thread(calculate);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        for (CalculatePower task : tasks) {
            totalPower += task.getPower();
        }

        return totalPower;
    }
}
